package com.at.service.news;

import com.at.pojo.News;
import com.at.pojo.alphavantage.AlphaVantageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service("alphavantageService")
public class AlphaVantageNewsServiceImpl implements NewsService{

    @Value("${news.alpha-vantage.api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<News> fetchLatestNews() {
        return null;
    }

    @Override
    public ResponseEntity<News[]> fetchStockNews(String stckSymbol, String startDate, String endDate) {
        String url = "https://www.alphavantage.co/query?function=NEWS_SENTIMENT&tickers=" + stckSymbol + "&apikey=" + apiKey;
        ResponseEntity<AlphaVantageResponse> response = restTemplate.getForEntity(url, AlphaVantageResponse.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            System.out.println("Size of list ==> " + response.getBody().getFeed().size());
            List<News> newsList =  response.getBody().getFeed().stream().map(f -> new News(f)).collect(Collectors.toList());
            System.out.println("newsList ==> " + newsList.size());
            return new ResponseEntity<>(newsList.toArray(new News[newsList.size()]), HttpStatus.OK);
        } else {
            throw new RuntimeException("Failed to fetch news for stock: " + stckSymbol);
        }
    }
}
