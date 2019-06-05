package com.gmail.nikolay.salahub.springbootmodule.servive.impl;

import com.gmail.nikolay.salahub.springbootmodule.repository.BusinessCardRepository;
import com.gmail.nikolay.salahub.springbootmodule.repository.model.BusinessCard;
import com.gmail.nikolay.salahub.springbootmodule.servive.BusinessCardService;
import com.gmail.nikolay.salahub.springbootmodule.servive.converter.BusinessCardConverter;
import com.gmail.nikolay.salahub.springbootmodule.servive.model.BusinessCardDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessCardServiceImpl implements BusinessCardService {

    private BusinessCardRepository businessCardRepository;
    private BusinessCardConverter businessCardConverter;
    private BusinessCardConverter businessAPICardConverter;

    public BusinessCardServiceImpl(BusinessCardRepository businessCardRepository,
                                   BusinessCardConverter businessCardConverter,
                                   @Qualifier("businessCardApiConverter") BusinessCardConverter businessAPICardConverter) {
        this.businessAPICardConverter = businessAPICardConverter;
        this.businessCardConverter = businessCardConverter;
        this.businessCardRepository = businessCardRepository;
    }

    @Override
    @Transactional
    public List<BusinessCardDTO> findAll() {
        List<BusinessCard> businessCards = businessCardRepository.findAll();
        List<BusinessCardDTO> businessCardDTOS = businessCards.stream()
                .map(businessCardConverter::toDTO)
                .collect(Collectors.toList());
        return businessCardDTOS;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        businessCardRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void create(BusinessCardDTO businessCardDTO) {
        BusinessCard businessCard = businessAPICardConverter.fromDTO(businessCardDTO);
        businessCard.setDeleted(false);
        businessCardRepository.persist(businessCard);
    }
}
