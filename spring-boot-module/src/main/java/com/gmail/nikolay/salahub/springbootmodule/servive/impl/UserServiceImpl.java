package com.gmail.nikolay.salahub.springbootmodule.servive.impl;

import com.gmail.nikolay.salahub.springbootmodule.repository.UserRepository;
import com.gmail.nikolay.salahub.springbootmodule.repository.model.User;
import com.gmail.nikolay.salahub.springbootmodule.servive.UserService;
import com.gmail.nikolay.salahub.springbootmodule.servive.converter.UserConverter;
import com.gmail.nikolay.salahub.springbootmodule.servive.exception.NoResultUserServiceException;
import com.gmail.nikolay.salahub.springbootmodule.servive.model.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final String NO_RESULT_SERVICE_EXCEPTION = "No result in database";

    private UserRepository userRepository;
    private UserConverter userConverter;

    public UserServiceImpl(UserRepository userRepository,
                           UserConverter userConverter) {
        this.userConverter = userConverter;
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO getByUsername(String username) {
        User user = userRepository.findByEmail(username);
        if (user != null) {
            return userConverter.toDTO(user);
        } else {
            throw new NoResultUserServiceException(NO_RESULT_SERVICE_EXCEPTION + username);
        }
    }
}
