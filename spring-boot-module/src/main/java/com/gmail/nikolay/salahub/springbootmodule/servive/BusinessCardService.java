package com.gmail.nikolay.salahub.springbootmodule.servive;

import com.gmail.nikolay.salahub.springbootmodule.servive.model.BusinessCardDTO;

import java.util.List;

public interface BusinessCardService {
    List<BusinessCardDTO> findAll();

    void delete(Long id);

    void create(BusinessCardDTO businessCardDTO);
}
