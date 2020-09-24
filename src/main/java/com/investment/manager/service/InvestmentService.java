package com.investment.manager.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.investment.manager.dto.InvestmentDTO;
import com.investment.manager.dto.UserDTO;
import com.investment.manager.mapper.InvestmentMapper;
import com.investment.manager.model.Investment;
import com.investment.manager.model.Profile;
import com.investment.manager.repository.InvestmentRepository;

import javassist.NotFoundException;

@Service
@Transactional
public class InvestmentService {

	@Autowired
	private InvestmentRepository investmentRepository;

	@Autowired
	private InvestmentMapper investmentMapper;

	public Page<InvestmentDTO> searchByCLient(UserDTO client, int page, int size) throws Exception {

		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "name");

		if (client.getProfile().equals(Profile.CUSTOMER))
			return investmentRepository.pagedSearchByBroker(client.getId(), pageRequest);

		throw new Exception("Nothing to show");

	}

	public Page<InvestmentDTO> searchByBroker(UserDTO broker, int page, int size) throws Exception {

		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "name");

		if (broker.getProfile().equals(Profile.BROKER))
			return investmentRepository.pagedSearchByBroker(broker.getId(), pageRequest);

		throw new Exception("Nothing to show");

	}

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

	public Page<InvestmentDTO> getAll(int page, int size) {

		@SuppressWarnings("static-access")
		PageRequest pageRequest = PageRequest.of(page, size, Sort.DEFAULT_DIRECTION.ASC);

		return new PageImpl<>(investmentMapper.toDTOs(investmentRepository.findAll()), pageRequest, size);

	}

	public void delete(Long id) {

		investmentRepository.deleteById(id);

	}
}
