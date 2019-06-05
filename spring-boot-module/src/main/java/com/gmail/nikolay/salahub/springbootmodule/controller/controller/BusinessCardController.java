package com.gmail.nikolay.salahub.springbootmodule.controller.controller;

import com.gmail.nikolay.salahub.springbootmodule.controller.validator.BusinessCardValidator;
import com.gmail.nikolay.salahub.springbootmodule.servive.BusinessCardService;
import com.gmail.nikolay.salahub.springbootmodule.servive.model.BusinessCardDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BusinessCardController {

    private final BusinessCardService businessCardService;
    private final BusinessCardValidator businessCardValidator;

    public BusinessCardController(BusinessCardService businessCardService,
                                  BusinessCardValidator businessCardValidator) {
        this.businessCardValidator = businessCardValidator;
        this.businessCardService = businessCardService;
    }

    @GetMapping("/api/customer/cards")
    public ResponseEntity<List<BusinessCardDTO>> showArticles() {
        List<BusinessCardDTO> orders = businessCardService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }


    @DeleteMapping("/api/administrator/delete/{id}")
    public ResponseEntity deleteById(
            @PathVariable(name = "id") Long id) {
        businessCardService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/api/administrator/add")
    private ResponseEntity createItem(@RequestBody BusinessCardDTO businessCardDTO,
                                      BindingResult bindingResult) {
        businessCardValidator.validate(businessCardDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

}
