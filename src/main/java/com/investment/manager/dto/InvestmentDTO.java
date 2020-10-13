package com.investment.manager.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class InvestmentDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private StockDTO stock;

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

	private UserDTO broker;

	private UserDTO customer;

	private List<InvestmentStatusDTO> status;

}
