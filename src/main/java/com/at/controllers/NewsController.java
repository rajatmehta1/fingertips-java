package com.at.controllers;

import com.at.pojo.News;
import com.at.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Go over all the News sources and pull and store the News
 * as a first version just print News on the screen
 *
 */
@RestController
@RequestMapping(path = "/news")
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

    @GetMapping("/alphavantage")
    public ResponseEntity<News[]> getNews3() {
        return  alphaVantageService.fetchStockNews("MSTR", "2024-01-10","2025-02-14");
    }
}
