package com.investment.manager.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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

    public BankDTO get(Long id) throws NotFoundException {

        Optional<Bank> bank = bankRepository.findById(id);

        if (bank.isPresent())
            return bankMapper.toDTO(bank.get());

        throw new NotFoundException("Bank not found");
    }

    public void delete(Long id) {

        bankRepository.deleteById(id);
    }

    public List<BankDTO> getAll() {
        return bankMapper.toDTOs(bankRepository.findAll());
    }
}
