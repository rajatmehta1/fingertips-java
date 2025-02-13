package com.at.pojo.alphavantage;

import lombok.Data;

import java.util.List;

@Data
public class AlphaVantageResponse {
   private List<NewsData> feed;
}
