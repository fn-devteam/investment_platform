package com.investment.manager.dto;

import java.util.Calendar;
import java.util.List;

import com.investment.manager.model.InvestmentStatus;
import com.investment.manager.model.Stock;
import com.investment.manager.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvestmentDTO {

	private Long id;

	private Stock stock;

	private String notice;

	private Double liquidity;

	private Double investedValue;

	private Double profitPercent;

	private Double profit;

	private Double quantAcquired;

	private Double quotaValue;

	private Calendar creationDate;

	private Calendar startInvestment;

	private Calendar endInvestment;

	private User broker;

	private User client;

	private List<InvestmentStatus> status;

}
