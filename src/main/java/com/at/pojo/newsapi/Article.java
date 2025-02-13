package com.at.pojo.newsapi;

import lombok.Data;

@Data
public class Article {
    private String title;
    private String description;
    private String url;
    private String publishedAt;
    private Source source;

    @Data
    public static class Source {
        private String id;
        private String name;
    }
}
