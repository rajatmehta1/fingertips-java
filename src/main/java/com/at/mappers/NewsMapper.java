package com.at.mappers;

import com.at.dto.NewsDTO;
import com.at.entity.News;

import java.sql.Date;

public class NewsMapper {

    // Convert NewsDTO to News Entity
    public static News toEntity(NewsDTO newsDTO) {
        News news = new News();
        news.setNewsid(newsDTO.getNewsid());
        news.setTitle(newsDTO.getTitle());
        news.setSource(newsDTO.getSource());
//        news.setPublicationdate(newsDTO.getPublicationdate());
        news.setContent(newsDTO.getContent());
        news.setUrl(newsDTO.getUrl());
        news.setTickerid(newsDTO.getTickerid());
        return news;
    }

    public static News toEntityFromNewUrl(com.at.pojo.News n,Integer tickerId) {
        News news = new News();
        news.setTitle(n.getTitle());
        news.setSource(n.getSource());
//        news.setPublicationdate(n.getTime_published());
        news.setContent(n.getDesc());
        news.setUrl(n.getUrl());
        news.setTickerid(tickerId);
        return news;
    }

    // Convert News Entity to NewsDTO
    public static NewsDTO toDTO(News news) {
        return new NewsDTO(
                news.getNewsid(),
                news.getTitle(),
                news.getSource(),
//                news.getPublicationdate(),
                news.getContent(),
                news.getUrl(),
                news.getTickerid()
        );
    }
}