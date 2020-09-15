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
public class BankDTO implements Serializable {
	
	protected String id;
	
    private String name;

    private Long code;
}
