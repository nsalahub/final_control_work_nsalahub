package com.gmail.nikolay.salahub.springbootmodule.servive.converter;

import com.gmail.nikolay.salahub.springbootmodule.repository.model.BusinessCard;
import com.gmail.nikolay.salahub.springbootmodule.servive.model.BusinessCardDTO;

public interface BusinessCardConverter {
    BusinessCard fromDTO(BusinessCardDTO businessCardDTO);

    BusinessCardDTO toDTO(BusinessCard businessCard);
}
