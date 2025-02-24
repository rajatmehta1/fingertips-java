package com.at.service;

import com.at.dao.TickersRepository;
import com.at.dto.TickerDTO;
import com.at.entity.Ticker;
import com.at.mappers.TickerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TickerService {

    @Autowired
    private TickersRepository tickersRepository;

    // Get all Tickers as DTOs
    public List<TickerDTO> getAllTickers() {
        List<Ticker> tickers = tickersRepository.findAll();
        return tickers.stream()
                .map(TickerMapper::toDTO) // Map each Ticker entity to TickerDTO
                .collect(Collectors.toList());
    }
}
