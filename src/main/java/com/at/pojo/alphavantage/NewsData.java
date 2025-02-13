package com.at.pojo.alphavantage;

import lombok.Data;

@Data
public class NewsData {
    private String title;
    private String url;
    private String time_published;
    private String summary;
    private String banner_image;
    private String source;
    private String overall_sentiment_score;
}
