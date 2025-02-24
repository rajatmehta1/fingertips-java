package com.at.mappers;

import com.at.dto.TickerDTO;
import com.at.entity.Ticker;

public class TickerMapper {

    // Convert Ticker Entity to TickerDTO
    public static TickerDTO toDTO(Ticker ticker) {
        return new TickerDTO(
                ticker.getTickerid(),
                ticker.getSymbol(),
                ticker.getCompanyname(),
                ticker.getSector(),
                ticker.getIndustry(),
                ticker.getKeypointdesc()
        );
    }

    // Convert TickerDTO to Ticker Entity
    public static Ticker toEntity(TickerDTO tickerDTO) {
        Ticker ticker = new Ticker();
        ticker.setTickerid(tickerDTO.getTickerId());
        ticker.setSymbol(tickerDTO.getSymbol());
        ticker.setCompanyname(tickerDTO.getCompanyName());
        ticker.setSector(tickerDTO.getSector());
        ticker.setIndustry(tickerDTO.getIndustry());
        ticker.setKeypointdesc(tickerDTO.getKeyPointDesc());
        return ticker;
    }
}
