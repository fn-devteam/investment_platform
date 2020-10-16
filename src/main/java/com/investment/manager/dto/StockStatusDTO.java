package com.investment.manager.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import com.investment.manager.model.Status;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class StockStatusDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Status status;

	private StockDTO stock;

	private List<UserDTO> users;

	private Calendar changeDate;

}