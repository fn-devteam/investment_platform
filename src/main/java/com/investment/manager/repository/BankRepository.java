package com.investment.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.investment.manager.model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
}
