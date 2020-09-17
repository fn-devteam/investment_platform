package com.investment.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.investment.manager.model.Investment;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {

}
