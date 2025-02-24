package com.at.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TickerDTO {
    private Integer tickerId;
    private String symbol;
    private String companyName;
    private String sector;
    private String industry;
    private String keyPointDesc;
    // Default Constructor
}
