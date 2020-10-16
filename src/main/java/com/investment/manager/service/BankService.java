package com.investment.manager.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.investment.manager.dto.BankDTO;
import com.investment.manager.mapper.BankMapper;
import com.investment.manager.model.Bank;
import com.investment.manager.repository.BankRepository;

import javassist.NotFoundException;

@Service
@Transactional
public class BankService {

	@Autowired
	private BankRepository bankRepository;

	@Autowired
	private BankMapper bankMapper;

	public void create(BankDTO dto) {

		Bank bank = bankMapper.toEntity(dto);
		bankRepository.save(bank);
	}

	public BankDTO getById(String id) throws NotFoundException {

		Optional<Bank> bank = bankRepository.findById(id);

		if (bank.isPresent())
			return bankMapper.toDTO(bank.get());

		throw new NotFoundException("Bank not found");
	}

	public void delete(String id) {
		bankRepository.deleteById(id);
	}

	public Page<BankDTO> getAll(int page, int size) {

		Pageable pageRequest = PageRequest.of(page, size);

		Page<Bank> banks = bankRepository.findAll(pageRequest);

		List<BankDTO> bankDtos = bankMapper.toDTOs(banks.getContent());

		return new PageImpl<>(bankDtos, pageRequest, banks.getTotalElements());
	}
	
	
}
