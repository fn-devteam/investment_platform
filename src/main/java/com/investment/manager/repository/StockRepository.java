package com.investment.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.investment.manager.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
