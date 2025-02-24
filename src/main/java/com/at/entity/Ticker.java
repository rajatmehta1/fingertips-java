package com.at.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tickers")
public class Ticker {
    @Id
    private Integer tickerid;
    private String symbol;
    private String companyname;
    private String sector;
    private String industry;
    private String keypointdesc;
}
