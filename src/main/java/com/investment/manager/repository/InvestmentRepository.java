package com.investment.manager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.investment.manager.model.Investment;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long> {


	public Page<Investment> searchByClient(String searchTerm, Pageable pageable);
	
	public Page<Investment> searchByBroker(String searchTerm, Pageable pageable);

}
