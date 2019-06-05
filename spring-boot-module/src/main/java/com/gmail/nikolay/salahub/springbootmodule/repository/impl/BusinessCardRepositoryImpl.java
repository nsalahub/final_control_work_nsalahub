package com.gmail.nikolay.salahub.springbootmodule.repository.impl;

import com.gmail.nikolay.salahub.springbootmodule.repository.BusinessCardRepository;
import com.gmail.nikolay.salahub.springbootmodule.repository.model.BusinessCard;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class BusinessCardRepositoryImpl extends GenericRepositoryImpl<Long, BusinessCard> implements BusinessCardRepository {
    @Override
    public List<BusinessCard> findAll() {
        String query = "from  BusinessCard";
        Query q = entityManager.createQuery(query);
        return q.getResultList();
    }

    @Override
    public void deleteById(Long id) {
        String hqlQuery = "UPDATE BusinessCard B SET B.isDeleted = true WHERE B.id =:id";
        Query query = entityManager.createQuery(hqlQuery);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
