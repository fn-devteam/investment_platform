package com.investment.manager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.investment.manager.dto.AccountDTO;
import com.investment.manager.model.Account;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class AccountMapper extends BaseMapper<Account, AccountDTO>{

}
