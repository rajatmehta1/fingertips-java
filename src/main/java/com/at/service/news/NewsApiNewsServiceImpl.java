package com.at.service.news;

import com.at.pojo.News;
import com.at.pojo.newsapi.NewsResponse;
import com.at.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("newsapiService")
public class NewsApiNewsServiceImpl implements NewsService {

    @Value("${news.newsapi.api.key}") // Add your API key in application.properties
    private String apiKey;

    @Value("${news.newsapi.url.everything}")
    private String baseUrl;
    private final RestTemplate restTemplate;

    @Autowired
    public NewsApiNewsServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<News> fetchLatestNews() {
        return null;
    }

    public ResponseEntity<News[]> fetchStockNews(String stckSymbol, String startDate, String endDate) {
        String url = baseUrl +"?q=" + stckSymbol + "&apiKey=" + apiKey;
        ResponseEntity<NewsResponse> response = restTemplate.getForEntity(url, NewsResponse.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            News[] resultNewsArr = response.getBody().getArticles().stream().map( a -> new News(a)).toArray(News[]::new);
            return new ResponseEntity<>(resultNewsArr, HttpStatus.OK);
        } else {
            throw new RuntimeException("Failed to fetch news for stock: " + stckSymbol);
        }
    }
}