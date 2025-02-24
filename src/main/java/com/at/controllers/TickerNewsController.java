package com.at.controllers;


import com.at.dto.TickerDTO;
import com.at.entity.Ticker;
import com.at.pojo.News;
import com.at.service.TickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * Fetch news on a stock from various news sources
 */
@RequestMapping(path = "/ft/tickers")
@RestController
public class TickerNewsController {

   @Autowired
   private TickerService tickerService;

   // GET endpoint to retrieve all Tickers as DTOs
   @GetMapping("/list")
   public List<TickerDTO> getAllTickers() {
      return tickerService.getAllTickers();
   }

}
