package com.investment.manager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.investment.manager.dto.StockDTO;
import com.investment.manager.model.Stock;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class StockMapper extends BaseMapper<Stock, StockDTO>{

}
