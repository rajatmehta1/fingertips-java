package com.at.controllers;

import com.at.dto.NewsDTO;
import com.at.dto.TickerDTO;
import com.at.mappers.NewsMapper;
import com.at.pojo.News;
import com.at.service.TickerService;
import com.at.service.news.NewsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Go over all the News sources and pull and store the News
 * as a first version just print News on the screen
 *
 */
@RestController
@RequestMapping(path = "/ft/news")
public class NewsController {



    @Autowired
    @Qualifier("finnhubService")
    NewsService finnhubService;

    @Autowired
    @Qualifier("newsapiService")
    NewsService newsApiService;

    @Autowired
    @Qualifier("alphavantageService")
    NewsService alphaVantageService;

    @Autowired
    com.at.service.NewsService newsServiceOnly;

    @Autowired
    TickerService tickerService;

    @GetMapping("/latest")
    public ResponseEntity<List<News>> latestNews() {
        return ResponseEntity.ok(finnhubService.fetchLatestNews());
    }

    @GetMapping("/finnhubb")
    public ResponseEntity<News> getNews() {
              return  ResponseEntity.ok(finnhubService.fetchStockNews("MSTR", "2024-01-10","2025-02-14").getBody()[0]);
    }

    @GetMapping("/newsapi")
    public ResponseEntity<News> getNews2() {
        return  ResponseEntity.ok(alphaVantageService.fetchStockNews("mstr", "2024-01-10","2025-02-14").getBody()[0]);
    }

    @GetMapping("/alphavantage/{ticker}")
    public ResponseEntity<News[]> getNews3(@PathVariable String ticker) {
        return  alphaVantageService.fetchStockNews(ticker, "2024-01-10","2025-22-14");
    }

    @Transactional
    @GetMapping("/av/{tickerId}")
    public ResponseEntity<List<NewsDTO>> getAndStoreAlpha(@PathVariable Integer tickerId) {
        TickerDTO tickerDTO = tickerService.findTickerById(tickerId);
        if(null == tickerDTO) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            List<com.at.entity.News> newsLst = alphaVantageService.fetchStockNewsAsLst(tickerDTO.getSymbol(), "2024-02-20","2025-02-25").stream().map(n -> NewsMapper.toEntityFromNewUrl(n,tickerId)).collect(Collectors.toList());
            newsServiceOnly.saveBulkNews(newsLst);
            return ResponseEntity.ok(newsServiceOnly.getNewsByTickerId(tickerId));
        }

    }
}
