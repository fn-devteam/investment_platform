package com.investment.manager.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.investment.manager.dto.UserDTO;
import com.investment.manager.mapper.UserMapper;
import com.investment.manager.model.User;
import com.investment.manager.repository.UserRepository;

import javassist.NotFoundException;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	public void create(UserDTO dto) {

		User user = userMapper.toEntity(dto);
		userRepository.save(user);
	}

	public UserDTO get(Long id) throws NotFoundException {

		Optional<User> user = userRepository.findById(id);

		if (user.isPresent())
			return userMapper.toDTO(user.get());

		throw new NotFoundException("User not found");
	}

	public void delete(Long id) {

		userRepository.deleteById(id);
	}

	public Page<UserDTO> getAll(int page, int size) {

		PageRequest pageRequest = PageRequest.of(page, size);

		Page<User> users = userRepository.findAll(pageRequest);

		List<UserDTO> userDto = userMapper.toDTOs(users.getContent());

		return new PageImpl<>(userDto, pageRequest, users.getTotalElements());
	}

	public Page<UserDTO> getAllBrokers(int page, int size) {

		PageRequest pageRequest = PageRequest.of(page, size);

		Page<User> users = userRepository.findAllBrokers(pageRequest);

		List<UserDTO> userDto = userMapper.toDTOs(users.getContent());

		return new PageImpl<>(userDto, pageRequest, users.getTotalElements());
	}

	public Page<UserDTO> getAllCustomers(int page, int size) {

		PageRequest pageRequest = PageRequest.of(page, size);

		Page<User> users = userRepository.findAllCustomers(pageRequest);

		List<UserDTO> userDto = userMapper.toDTOs(users.getContent());

		return new PageImpl<>(userDto, pageRequest, users.getTotalElements());
	}
}
