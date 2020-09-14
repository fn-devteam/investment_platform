package com.investment.manager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.investment.manager.dto.BankDTO;
import com.investment.manager.model.Bank;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class BankMapper extends BaseMapper<Bank, BankDTO> {
}
