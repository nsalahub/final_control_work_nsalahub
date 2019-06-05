package com.gmail.nikolay.salahub.springbootmodule.servive.converter.impl;

import com.gmail.nikolay.salahub.springbootmodule.repository.model.BusinessCard;
import com.gmail.nikolay.salahub.springbootmodule.servive.converter.BusinessCardConverter;
import com.gmail.nikolay.salahub.springbootmodule.servive.converter.UserConverter;
import com.gmail.nikolay.salahub.springbootmodule.servive.model.BusinessCardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("businessCardApiConverter")
public class BusinessCardApiConverterImpl implements BusinessCardConverter {

    private UserConverter userConverter;

    @Autowired
    public BusinessCardApiConverterImpl(UserConverter userConverter){
        this.userConverter = userConverter;
    }

    @Override
    public BusinessCard fromDTO(BusinessCardDTO businessCardDTO) {
        BusinessCard businessCard = new BusinessCard();
        businessCard.setFullName(businessCardDTO.getFullName());
        businessCard.setTelephone(businessCardDTO.getTelephone());
        businessCard.setTitle(businessCardDTO.getTitle());
        businessCard.setUser(userConverter.fromDTO(businessCardDTO.getUserDTO()));
        return businessCard;
    }

    @Override
    public BusinessCardDTO toDTO(BusinessCard businessCard) {
        return null;
    }
}
