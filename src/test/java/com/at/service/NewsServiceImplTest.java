package com.at.service;

import com.at.pojo.News;
import com.at.service.news.NewsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class NewsServiceImplTest {

    @Autowired
    NewsService newsService;

    @Test
    public void testFinnhubNews() {
        ResponseEntity<News[]> response = newsService.fetchFinhubNews("AAPL","2024-12-21", "2024-12-23");
        Assertions.assertNotEquals(0,response.getBody().length);
    }

}
