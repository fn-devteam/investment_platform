package com.investment.manager.dto;

import java.io.Serializable;

import com.investment.manager.model.Bank;
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
public class AccountDTO implements Serializable{
	
	 private static final long serialVersionUID = 1L;

	 private Long id;
	
	 private Bank bank;

	 private String agency;

	 private String digit;

	 private String accountNumber;

	 private String accountDigit;

	 private User user;
}
