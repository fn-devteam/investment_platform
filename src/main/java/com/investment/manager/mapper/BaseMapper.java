package com.investment.manager.mapper;

/**
 * @param <E> Entity
 * @param <D> DTO
 * */
public abstract class BaseMapper<E,D> {

    public abstract E toEntity(D dto);

    public abstract D toDTO(E dto);

}
