package com.investment.manager.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class StockDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private StockTypeDTO type;

	private List<StockStatusDTO> status;

	private String name;

	private UserDTO creator;

	private Date creationDate;

	private String description;

	private Double liquidity;

	private Double profitPercent;

	private Double availQuantity;

	private Double quotaValue;

}
