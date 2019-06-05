package com.gmail.nikolay.salahub.springbootmodule.servive.impl;


import com.gmail.nikolay.salahub.springbootmodule.servive.UserService;
import com.gmail.nikolay.salahub.springbootmodule.servive.model.UserDTO;

import com.gmail.nikolay.salahub.springbootmodule.servive.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("appUserDetailsService")
public class AppUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public AppUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user = userService.getByUsername(username);
        System.out.println(user.getRole());
        System.out.println(username);
        System.out.println(user.getPassword());
        if (user == null) {
            throw new UsernameNotFoundException("User is not found");
        }
        return new UserPrincipal(user);
    }
}
