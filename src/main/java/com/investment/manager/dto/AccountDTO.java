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
public class AccountDTO implements Serializable {
	
	 private static final long serialVersionUID = 1L;

	 private Long id;
	
	 private BankDTO bank;

	 private String agency;

	 private String digit;

	 private String accountNumber;

	 private String accountDigit;

	 private UserDTO user;
}
