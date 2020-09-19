package com.investment.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.investment.manager.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
