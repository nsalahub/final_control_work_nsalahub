package com.gmail.nikolay.salahub.springbootmodule.servive;

import com.gmail.nikolay.salahub.springbootmodule.servive.model.UserDTO;

public interface UserService {
    UserDTO getByUsername(String username);
}
