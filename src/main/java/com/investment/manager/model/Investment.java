package com.investment.manager.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Investment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@ManyToOne
	Stock stock;

	String notice;
	
	Double liquidity;
	
	Double investedValue;
	
	Double profitPercent;
	
	Double profit;
	
	Double quantAcquired;
	
	Double quotaValue;
	
	@CreatedDate
	Calendar creationDate;
	
	Calendar startInvestment;
	
	Calendar endInvestment;
	
	@ManyToOne
	User broker;
	
	@ManyToOne
	User client;
	
	@OneToMany
	List<InvestmentStatus> status;
	
	
	
	
}
