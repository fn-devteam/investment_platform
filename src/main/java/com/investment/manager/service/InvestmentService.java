package com.investment.manager.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investment.manager.dto.InvestmentDTO;
import com.investment.manager.mapper.InvestmentMapper;
import com.investment.manager.model.Investment;
import com.investment.manager.repository.InvestmentRepository;

import javassist.NotFoundException;

@Service
@Transactional
public class InvestmentService {

	@Autowired
	private InvestmentRepository investmentRepository;

	@Autowired
	private InvestmentMapper investmentMapper;

	public void create(InvestmentDTO dto) {
		Investment investment = investmentMapper.toEntity(dto);
		investmentRepository.save(investment);
	}

	public InvestmentDTO get(Long id) throws NotFoundException {
		Optional<Investment> investment = investmentRepository.findById(id);

		if (investment.isPresent())
			return investmentMapper.toDTO(investment.get());

		throw new NotFoundException("Investment not found");
	}

	public List<InvestmentDTO> getAll() {

		return investmentMapper.toDTOs(investmentRepository.findAll());

	}

	public void delete(Long id) {

		investmentRepository.deleteById(id);

	}
}
