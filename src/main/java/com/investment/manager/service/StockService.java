package com.investment.manager.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.investment.manager.dto.StockDTO;
import com.investment.manager.mapper.StockMapper;
import com.investment.manager.model.Stock;
import com.investment.manager.repository.StockRepository;

import javassist.NotFoundException;

@Service
@Transactional
public class StockService {

	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private StockMapper stockMapper;

	public void create(StockDTO dto) {

		Stock stock = stockMapper.toEntity(dto);
		stockRepository.save(stock);

	}

	public StockDTO get(Long id) throws NotFoundException {
		Optional<Stock> stock = stockRepository.findById(id);

		if (stock.isPresent())
			return stockMapper.toDTO(stock.get());

		throw new NotFoundException("Stock type not found");
	}

	public Page<StockDTO> getAll(int page, int size) {

		PageRequest pageRequest = PageRequest.of(page, size);

		Page<Stock> stock = stockRepository.findAll(pageRequest);

		List<StockDTO> stockDto = stockMapper.toDTOs(stock.getContent());

		return new PageImpl<>(stockDto, pageRequest, stock.getTotalElements());

	}

	public void delete(Long id) {

		stockRepository.deleteById(id);

	}

}
