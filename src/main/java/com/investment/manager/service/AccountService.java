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

import com.investment.manager.dto.AccountDTO;
import com.investment.manager.mapper.AccountMapper;
import com.investment.manager.model.Account;
import com.investment.manager.repository.AccountRepository;

import javassist.NotFoundException;

@Service
@Transactional
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountMapper accountMapper;

	public void create(AccountDTO dto) {

		Account account = accountMapper.toEntity(dto);
		accountRepository.save(account);
	}

	public AccountDTO get(Long id) throws NotFoundException {

		Optional<Account> account = accountRepository.findById(id);

		if (account.isPresent()) {
			return accountMapper.toDTO(account.get());
		}

		throw new NotFoundException("Account Not Found");
	}

	public void delete(Long id) {

		accountRepository.deleteById(id);

	}

	public Page<AccountDTO> getAll(int page, int size) {

		Pageable pageRequest = PageRequest.of(page, size);

		Page<Account> account = accountRepository.findAll(pageRequest);

		List<AccountDTO> accountDTO = accountMapper.toDTOs(account.getContent());

		return new PageImpl<>(accountDTO, pageRequest, account.getTotalElements());

	}
	

}
