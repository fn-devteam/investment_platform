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

import com.investment.manager.dto.StockDTO;
import com.investment.manager.service.StockService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private StockService stockService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestParam("stock") StockDTO dto) {

		stockService.create(dto);

	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<StockDTO> getAll(
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws NotFoundException {
		return stockService.getAll(page, size);

	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StockDTO getById(@PathVariable("id") Long id) throws NotFoundException {

		return stockService.get(id);

	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable("id") Long id) throws NotFoundException {

		stockService.delete(id);

	}

}
