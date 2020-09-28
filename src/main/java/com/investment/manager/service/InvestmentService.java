package com.investment.manager.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

		Pageable pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "name");

		if (client.getProfile().equals(Profile.BROKER)) {

			Page<Investment> investments = investmentRepository.pagedSearchByClient(pageRequest, client.getId());

			List<InvestmentDTO> investmentDTOs = investmentMapper.toDTOs(investments.getContent());

			return new PageImpl<>(investmentDTOs, pageRequest, investments.getTotalElements());
		}

		throw new Exception("Nothing to show");

	}

	public Page<InvestmentDTO> searchByBroker(UserDTO broker, int page, int size) throws Exception {

		Pageable pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "id");
		System.out.println("pageRequest" + pageRequest);

		if (broker.getProfile().equals(Profile.BROKER)) {

			Page<Investment> investments = investmentRepository.pagedSearchByBroker(pageRequest, broker.getId());

			List<InvestmentDTO> investmentDTOs = investmentMapper.toDTOs(investments.getContent());

			return new PageImpl<>(investmentDTOs, pageRequest, investments.getTotalElements());
		}

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

		Pageable pageRequest = PageRequest.of(page, size);

		Page<Investment> investmentPage = investmentRepository.findAll(pageRequest);

		return new PageImpl<>(investmentMapper.toDTOs(investmentPage.getContent()), pageRequest,
				investmentPage.getTotalElements());

	}

	public void delete(Long id) {

		investmentRepository.deleteById(id);

	}
}
