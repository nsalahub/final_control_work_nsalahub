package com.gmail.nikolay.salahub.springbootmodule.servive.converter.impl;

import com.gmail.nikolay.salahub.springbootmodule.repository.model.BusinessCard;
import com.gmail.nikolay.salahub.springbootmodule.servive.converter.BusinessCardConverter;
import com.gmail.nikolay.salahub.springbootmodule.servive.converter.UserConverter;
import com.gmail.nikolay.salahub.springbootmodule.servive.model.BusinessCardDTO;
import org.springframework.stereotype.Component;

@Component("businessCardConverter")
public class BusinessCardConverterImpl implements BusinessCardConverter {

    private UserConverter userConverter;

    public BusinessCardConverterImpl(UserConverter userConverter) {
        this.userConverter = userConverter;
    }

    @Override
    public BusinessCard fromDTO(BusinessCardDTO businessCardDTO) {
        BusinessCard businessCard = new BusinessCard();
        businessCard.setId(businessCardDTO.getId());
        businessCard.setDeleted(businessCardDTO.isDeleted());
        businessCard.setFullName(businessCardDTO.getFullName());
        businessCard.setTelephone(businessCardDTO.getTelephone());
        businessCard.setTitle(businessCardDTO.getTitle());
        businessCard.setUser(userConverter.fromDTO(businessCardDTO.getUserDTO()));
        return businessCard;
    }

    @Override
    public BusinessCardDTO toDTO(BusinessCard businessCard) {
        BusinessCardDTO businessCardDTO = new BusinessCardDTO();
        businessCardDTO.setDeleted(businessCard.isDeleted());
        businessCardDTO.setId(businessCard.getId());
        businessCardDTO.setUserDTO(userConverter.toDTO(businessCard.getUser()));
        businessCardDTO.setTelephone(businessCard.getTelephone());
        businessCardDTO.setFullName(businessCardDTO.getFullName());
        businessCardDTO.setTitle(businessCardDTO.getTitle());
        return businessCardDTO;
    }
}
