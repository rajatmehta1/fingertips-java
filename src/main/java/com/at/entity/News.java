package com.at.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "news")
@Data
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newsid;

    private String title;

    private String source;

    private String publicationdate;

    private String content;

    private String url;

    private Integer tickerid;

}
