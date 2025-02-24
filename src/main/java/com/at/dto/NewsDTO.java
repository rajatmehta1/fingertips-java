package com.at.dto;

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
public class NewsDTO {
    private Long newsid;
    private String title;
    private String source;
//    private String publicationdate;
    private String content;
    private String url;
    private Integer tickerid;
}