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

import com.investment.manager.dto.UserDTO;
import com.investment.manager.service.UserService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestParam("user") UserDTO dto) {
		userService.create(dto);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<UserDTO> getAll(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws Exception {

		return userService.getAll(page, size);
	}

	@GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<UserDTO> getAllCustomers(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws Exception {

		return userService.getAllCustomers(page, size);
	}

	@GetMapping(value = "/brokers", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<UserDTO> getAllBrokers(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws Exception {

		return userService.getAllBrokers(page, size);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO findById(@PathVariable("id") Long id) throws NotFoundException {
		return userService.get(id);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Long id) {
		userService.delete(id);
	}
}
