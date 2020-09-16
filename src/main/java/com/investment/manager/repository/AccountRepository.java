package com.investment.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.investment.manager.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
