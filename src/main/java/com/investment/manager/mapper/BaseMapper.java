package com.investment.manager.mapper;

import java.util.List;

/**
 * @param <E> Entity
 * @param <D> DTO
 * */
public abstract class BaseMapper<E, D> {

    public abstract E toEntity(D dto);

    public abstract D toDTO(E dto);

    public abstract List<E> toEntities(List<D> dtos);

    public abstract List<D> toDTOs(List<E> dtos);

}
