package com.at.pojo;

import com.at.pojo.alphavantage.NewsData;
import com.at.pojo.newsapi.Article;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class News {

    //copy constructor - news api
    public News(Article article) {
        this.url = article.getUrl();
        this.publishedAt = article.getPublishedAt();
        this.title = article.getTitle();
        this.desc = article.getDescription();
        this.source = article.getSource().getName();
    }

    //copy constructor - Alpha vantage
    public News(NewsData article) {
        this.desc = article.getSummary();
        this.title = article.getTitle();

    }


    int id;
    @JsonProperty("headline")
    String title;

    @JsonProperty("summary")
    String desc;

    String url;

    String category;

    String datetime;

    String publishedAt;

    String source;

    String overall_sentiment_score;

    String time_published;
}
