package com.investment.manager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.investment.manager.dto.InvestmentDTO;
import com.investment.manager.model.Investment;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class InvestmentMapper extends BaseMapper<Investment, InvestmentDTO> {

}
