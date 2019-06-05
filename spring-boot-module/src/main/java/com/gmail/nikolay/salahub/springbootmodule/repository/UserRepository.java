package com.gmail.nikolay.salahub.springbootmodule.repository;

import com.gmail.nikolay.salahub.springbootmodule.repository.model.User;

public interface UserRepository extends GenericRepository<Long, User> {
    User findByEmail(String username);
}
