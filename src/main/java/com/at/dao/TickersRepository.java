package com.at.dao;

import com.at.entity.Ticker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TickersRepository extends JpaRepository<Ticker, Integer> {
}
