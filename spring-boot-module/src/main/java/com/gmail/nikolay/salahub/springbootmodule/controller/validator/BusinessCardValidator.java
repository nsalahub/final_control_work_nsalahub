package com.gmail.nikolay.salahub.springbootmodule.controller.validator;

import com.gmail.nikolay.salahub.springbootmodule.servive.model.BusinessCardDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class BusinessCardValidator implements Validator {

    private static final Integer MAX_LENGTH_TELEPHONE = 20;
    private static final String VALIDATION_LENGTH_TELEPHONE_MESSAGE = "error length telephone";

    @Override
    public boolean supports(Class<?> aClass) {
        return BusinessCardDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "title", "", "empty title");

        BusinessCardDTO businessCardDTO = (BusinessCardDTO) o;

        if (businessCardDTO.getTelephone().length() > MAX_LENGTH_TELEPHONE) {
            errors.rejectValue("telephone", "", VALIDATION_LENGTH_TELEPHONE_MESSAGE);
        }
    }
}
