package com.investment.manager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.investment.manager.model.Investment;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long> {

	@Query("SELECT i FROM Investment i WHERE i.broker.id = :id")
	public Page<Investment> pagedSearchByBroker(Pageable pageable, @Param("id") Long id);
	
	@Query("SELECT i FROM Investment i WHERE i.customer.id = :id")
	public Page<Investment> pagedSearchByCustomer(Pageable pageable, @Param("id") Long id);

}
	