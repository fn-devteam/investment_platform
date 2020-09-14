package com.investment.manager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.investment.manager.dto.UserDTO;
import com.investment.manager.model.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UserMapper extends BaseMapper<User, UserDTO>{
}
