package com.gmail.nikolay.salahub.springbootmodule.servive.model;

import com.gmail.nikolay.salahub.springbootmodule.repository.model.BusinessCard;
import com.gmail.nikolay.salahub.springbootmodule.repository.model.RoleEnum;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private boolean isDeleted;
    private String role;
    List<BusinessCard> businessCards = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<BusinessCard> getBusinessCards() {
        return businessCards;
    }

    public void setBusinessCards(List<BusinessCard> businessCards) {
        this.businessCards = businessCards;
    }
}
