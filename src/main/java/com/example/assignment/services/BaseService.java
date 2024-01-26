package com.example.assignment.services;

import java.util.List;

import jakarta.transaction.Transactional;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<D, ID> {

    String NOT_FOUND = "404 Not Found";

    List<D> getAll();

    Page<D> getAll(Pageable pageable);

    D getById(ID id) throws ServiceException;

    @Transactional
    void create(D dto);

    @Transactional
    void update(D dto, ID id) throws ServiceException;

    @Transactional
    void deleteById(ID id) throws ServiceException;

}
