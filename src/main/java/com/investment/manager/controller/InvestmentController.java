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

import com.investment.manager.dto.InvestmentDTO;
import com.investment.manager.dto.UserDTO;
import com.investment.manager.service.InvestmentService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/investment")
public class InvestmentController {

	@Autowired
	private InvestmentService investmentService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestParam("invesment") InvestmentDTO investment) {

		investmentService.create(investment);

	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public InvestmentDTO getById(@PathVariable("id") Long id) throws NotFoundException {

		return investmentService.get(id);

	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<InvestmentDTO> getAll(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {

		return investmentService.getAll(page, size);

	}

	@GetMapping(value = "/broker/{broker}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<InvestmentDTO> getByBroker(@RequestParam("broker") UserDTO broker,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws Exception {

		return investmentService.searchByBroker(broker, page, size);

	}

	@GetMapping(value = "/client/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<InvestmentDTO> getByClient(@RequestParam("id") UserDTO client,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws Exception {

		return investmentService.searchByCLient(client, page, size);

	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Long id) {

		investmentService.delete(id);

	}

}
