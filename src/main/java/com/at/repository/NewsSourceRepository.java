package com.at.repository;

import com.at.entity.NewsSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsSourceRepository extends JpaRepository<NewsSource,Integer> {
}
