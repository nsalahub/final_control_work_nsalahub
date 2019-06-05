package com.gmail.nikolay.salahub.springbootmodule.repository.impl;

import com.gmail.nikolay.salahub.springbootmodule.repository.UserRepository;
import com.gmail.nikolay.salahub.springbootmodule.repository.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
public class UserRepositoryImpl extends GenericRepositoryImpl<Long, User> implements UserRepository {
    @Override
    public User findByEmail(String username) {
        String hqlQuery = "from User as U where U.username=:username";
        Query query = entityManager.createQuery(hqlQuery);
        query.setParameter("username", username);
        try {
            return (User) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
