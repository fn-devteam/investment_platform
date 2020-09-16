package com.investment.manager.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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

	public List<StockDTO> getAll() {

		return stockMapper.toDTOs(stockRepository.findAll());

	}

	public void delete(Long id) {

		stockRepository.deleteById(id);

	}

}
