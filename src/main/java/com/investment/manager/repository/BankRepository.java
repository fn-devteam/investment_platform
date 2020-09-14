package com.investment.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.investment.manager.model.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
