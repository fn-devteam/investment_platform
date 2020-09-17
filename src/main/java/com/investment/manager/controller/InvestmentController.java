package com.investment.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.investment.manager.dto.InvestmentDTO;
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
	public List<InvestmentDTO> getAll() {

		return investmentService.getAll();

	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Long id) {

		investmentService.delete(id);

	}

}
