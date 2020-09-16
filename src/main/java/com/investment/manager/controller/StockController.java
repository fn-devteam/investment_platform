package com.investment.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	StockService stockService;

	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestParam("stock") StockDTO dto) {

		stockService.create(dto);

	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StockDTO> getAll() {

		return stockService.getAll();

	}

	@RequestMapping(name = "id", produces = MediaType.APPLICATION_JSON_VALUE)
	public StockDTO getById(@PathVariable("id") Long id) throws NotFoundException {

		return stockService.get(id);

	}

	@DeleteMapping(name = "id", produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable("id") Long id) throws NotFoundException {

		stockService.delete(id);

	}

}
