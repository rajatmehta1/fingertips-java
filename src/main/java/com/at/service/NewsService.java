package com.at.service;

import com.at.dao.NewsRepository;
import com.at.dto.NewsDTO;
import com.at.entity.News;
import com.at.mappers.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsService {
    @Autowired
    NewsRepository newsRepository;


    // Save a news item to the database
    public News saveNews(News news) {
        return newsRepository.save(news);
    }

    public void saveBulkNews(List<News> news) {
        newsRepository.saveAll(news);
    }

    // Get all news items
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    // Get a news item by ID
    public Optional<News> getNewsById(Long newsId) {
        return newsRepository.findById(newsId);
    }

    // Get news items by ticker ID
    public List<NewsDTO> getNewsByTickerId(Integer tickerId) {
        return newsRepository.findByTickerid(tickerId).stream().map(NewsMapper::toDTO).collect(Collectors.toList());
    }

    // Delete a news item by ID
    public void deleteNewsById(Long newsId) {
        newsRepository.deleteById(newsId);
    }
}
