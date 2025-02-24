package com.at.dao;

import com.at.entity.Ticker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TickersRepository extends JpaRepository<Ticker, Integer> {
}
