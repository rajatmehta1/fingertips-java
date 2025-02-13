package com.at.pojo.newsapi;

import lombok.Data;
import java.util.List;

@Data
public class NewsResponse {
    private String status;
    private int totalResults;
    private List<Article> articles;
}

