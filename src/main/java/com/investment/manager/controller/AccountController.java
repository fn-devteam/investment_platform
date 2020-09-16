package com.investment.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.investment.manager.dto.AccountDTO;
import com.investment.manager.service.AccountService;

import javassist.NotFoundException;

@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestParam("account") AccountDTO account) {

		accountService.create(account);

	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AccountDTO> getAll() throws NotFoundException {

		return accountService.getAll();

	}

	@GetMapping(name = "id", produces = MediaType.APPLICATION_JSON_VALUE)
	public AccountDTO getById(@RequestParam("id") Long id) throws NotFoundException {

		return accountService.get(id);

	}

	@DeleteMapping(name = "id")
	public void delete(@RequestParam("id") Long id) throws NotFoundException {

		accountService.delete(id);

	}
}
