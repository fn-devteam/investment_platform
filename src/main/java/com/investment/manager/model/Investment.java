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
	private Long id;
	
	@ManyToOne
	private Stock stock;

	private String notice;
	
	private Double liquidity;
	
	private Double investedValue;
	
	private Double profitPercent;
	
	private Double profit;
	
	private Double quantAcquired;
	
	private Double quotaValue;
	
	@CreatedDate
	private Calendar creationDate;
	
	private Calendar startInvestment;
	
	private Calendar endInvestment;
	
	@ManyToOne
	private User broker;
	
	@ManyToOne
	private User customer;
	
	@OneToMany( mappedBy = "investment")
	private List<InvestmentStatus> status;
	
	
	
	
}
