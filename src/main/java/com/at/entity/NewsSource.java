package com.at.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Table(name = "news_source")
@Data
public class NewsSource {

    @Id
    @Column(name = "source_id")
    private int sourceId;

    @Column(name = "source_name")
    private String sourceName;

    @Column(name = "source_desc")
    private String sourceDesc;

    @Column(name = "source_url")
    private String sourceUrl;
}
