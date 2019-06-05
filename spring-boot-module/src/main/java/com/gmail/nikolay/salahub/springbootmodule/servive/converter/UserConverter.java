package com.gmail.nikolay.salahub.springbootmodule.servive.converter;

import com.gmail.nikolay.salahub.springbootmodule.repository.model.User;
import com.gmail.nikolay.salahub.springbootmodule.servive.model.UserDTO;

public interface UserConverter {

    User fromDTO(UserDTO userDTO);

    UserDTO toDTO(User user);
}
