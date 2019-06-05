package com.gmail.nikolay.salahub.springbootmodule.repository;

import com.gmail.nikolay.salahub.springbootmodule.repository.model.BusinessCard;

import java.util.List;

public interface BusinessCardRepository extends GenericRepository<Long, BusinessCard> {

    List<BusinessCard> findAll();

    void deleteById(Long id);
}
