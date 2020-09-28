package com.investment.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.investment.manager.dto.AccountDTO;
import com.investment.manager.service.AccountService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestParam("account") AccountDTO account) {

		accountService.create(account);

	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<AccountDTO> getAll(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws NotFoundException {

		return accountService.getAll(page, size);

	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AccountDTO getById(@PathVariable("id") Long id) throws NotFoundException {

		return accountService.get(id);

	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Long id) throws NotFoundException {

		accountService.delete(id);

	}
}
