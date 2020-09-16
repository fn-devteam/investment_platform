package com.investment.manager.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.investment.manager.model.StockStatus;
import com.investment.manager.model.StockType;
import com.investment.manager.model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class StockDTO implements Serializable{
	
	private Long id;

	private StockType type;

	private String name;
	
	private User creator;

	private Date creationDate;
	
	private String description;

	private Double liquidity;

	private Double profitPercent;

	private Double availQuantity;

	private Double quotaValue;

	private List<StockStatus> status;


}
