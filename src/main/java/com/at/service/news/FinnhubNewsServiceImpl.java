package com.at.service.news;

import com.at.pojo.News;
import com.at.repository.NewsSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

//pull News from different sources
@Service("finnhubService")
public class FinnhubNewsServiceImpl implements NewsService {

    @Autowired
    NewsSourceRepository newsSourceRepository;

    @Autowired
    RestTemplate restTemplate;

    @Value("${news.finnhubh.url}")
    private String newsUrlFinnhub;

    @Value("${news.finnhubh.api.key}")
    private String finnhubToken;

    public List<News> fetchLatestNews() {
        List<News> newsList = new ArrayList<>();
        newsSourceRepository.findAll()
                            .stream()
                            .forEach( ns -> newsList.add(News.builder().desc(ns.getSourceDesc()).build()));
        return newsList;
    }

    public ResponseEntity<News[]> fetchStockNews(String stckSymbol, String startDate, String endDate) {
        URI uri = UriComponentsBuilder.fromUriString(newsUrlFinnhub)
                                .queryParam("symbol",stckSymbol)
                                .queryParam("from",startDate)
                                .queryParam("to",endDate)
                                .queryParam("token",finnhubToken)
                                .build().toUri();
        ResponseEntity<News[]> newsResp = restTemplate.getForEntity(uri.toString(),News[].class);
//        return Arrays.asList(newsResp.getBody());
        return newsResp;
    }

}
