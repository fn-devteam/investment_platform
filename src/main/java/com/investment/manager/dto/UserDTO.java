package com.investment.manager.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import com.investment.manager.model.Account;
import com.investment.manager.model.Profile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String password;

	private Calendar createdAt;

	private Profile profile;

	private List<Account> accounts;

	private List<String> emails;

	private List<String> documents;

	private List<Integer> phones;

}
