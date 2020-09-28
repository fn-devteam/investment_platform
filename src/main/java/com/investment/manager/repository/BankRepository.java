package com.investment.manager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.investment.manager.model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, String> {
	
	@Query(" SELECT b FROM Bank b WHERE b.code = :id")
	public Bank pagedSearchByCode(@Param("id") String id);
	
	@Query(" SELECT b FROM Bank b WHERE b.name LIKE %:name%")
	public Page<Bank> pagedSearchByName(Pageable pageable, @Param("name") String name);
}
