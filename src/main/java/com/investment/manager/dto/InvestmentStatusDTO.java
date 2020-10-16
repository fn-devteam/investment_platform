package com.investment.manager.dto;

import java.io.Serializable;
import java.util.Calendar;

import com.investment.manager.model.Status;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class InvestmentStatusDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Status status;

	private Calendar changeDate;

}
