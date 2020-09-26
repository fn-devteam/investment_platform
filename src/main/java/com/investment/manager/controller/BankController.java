package com.investment.manager.controller;

import java.util.List;

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

import com.investment.manager.dto.BankDTO;
import com.investment.manager.dto.InvestmentDTO;
import com.investment.manager.service.BankService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/banks")
public class BankController {

	@Autowired
	private BankService bankService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestParam("bank") BankDTO dto) {
		bankService.create(dto);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<BankDTO> getAll(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws NotFoundException {
		return bankService.getAll(page, size);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BankDTO findById(@PathVariable("id") String id) throws NotFoundException {

		return bankService.getById(id);

	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") String id) {
		bankService.delete(id);
	}
}
