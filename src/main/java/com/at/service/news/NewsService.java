package com.at.service.news;

import com.at.pojo.News;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NewsService {
    public List<News> fetchLatestNews();
    public ResponseEntity<News[]> fetchStockNews(String stckSymbol, String startDate, String endDate);
}
