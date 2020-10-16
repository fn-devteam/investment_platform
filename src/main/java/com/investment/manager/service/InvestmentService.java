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

	public Page<InvestmentDTO> searchByCustomer(Long customer, int page, int size)
			throws NotFoundException {

		Pageable pageRequest = PageRequest.of(page, size);

		if (customer != 0) {
			Page<Investment> investments = investmentRepository.pagedSearchByCustomer(pageRequest, customer);

			List<InvestmentDTO> investmentDTOs = investmentMapper.toDTOs(investments.getContent());

			return new PageImpl<>(investmentDTOs, pageRequest, investments.getTotalElements());
		}

		throw new NotFoundException("Nothing to show");

	}

	public Page<InvestmentDTO> searchByBroker(Long broker, int page, int size)
			throws NotFoundException {

		Pageable pageRequest = PageRequest.of(page, size);


		if (broker != 0) {
			Page<Investment> investments = investmentRepository.pagedSearchByBroker(pageRequest,broker);

			List<InvestmentDTO> investmentDTOs = investmentMapper.toDTOs(investments.getContent());

			return new PageImpl<>(investmentDTOs, pageRequest, investments.getTotalElements());
		}

		throw new NotFoundException("Nothing to show");

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

		Pageable pageRequest = PageRequest.of(page, size);

		Page<Investment> investmentPage = investmentRepository.findAll(pageRequest);

		List<InvestmentDTO> investmentDTO = investmentMapper.toDTOs(investmentPage.getContent());

		return new PageImpl<>(investmentDTO, pageRequest, investmentPage.getTotalElements());

	}

	public void delete(Long id) {

		investmentRepository.deleteById(id);

	}
}
