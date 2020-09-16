package com.investment.manager.dto;

import java.io.Serializable;

import com.investment.manager.model.Bank;
import com.investment.manager.model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class AccountDTO implements Serializable{

	 protected Long id;
	
	 private Bank bank;

	 private String agency;

	 private String digit;

	 private String accountNumber;

	 private String accountDigit;

	 private User user;
}
