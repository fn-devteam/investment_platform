package com.investment.manager.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class StockTypeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

}
