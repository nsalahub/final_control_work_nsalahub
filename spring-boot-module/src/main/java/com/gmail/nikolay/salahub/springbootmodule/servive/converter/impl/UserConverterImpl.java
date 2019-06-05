package com.gmail.nikolay.salahub.springbootmodule.servive.converter.impl;

import com.gmail.nikolay.salahub.springbootmodule.repository.model.RoleEnum;
import com.gmail.nikolay.salahub.springbootmodule.repository.model.User;
import com.gmail.nikolay.salahub.springbootmodule.servive.converter.UserConverter;
import com.gmail.nikolay.salahub.springbootmodule.servive.model.UserDTO;
import org.springframework.stereotype.Component;

@Component("userConverter")
public class UserConverterImpl implements UserConverter {

    @Override
    public User fromDTO(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setDeleted(userDTO.isDeleted());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setRole(RoleEnum.valueOf(userDTO.getRole()));
        user.setBusinessCards(userDTO.getBusinessCards());
        return user;
    }

    @Override
    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(userDTO.getRole());
        userDTO.setDeleted(user.isDeleted());
        userDTO.setBusinessCards(user.getBusinessCards());
        userDTO.setId(user.getId());
        return userDTO;
    }
}
