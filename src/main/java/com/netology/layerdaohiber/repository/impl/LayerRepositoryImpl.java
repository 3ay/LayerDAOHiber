package com.netology.layerdaohiber.repository.impl;

import com.netology.layerdaohiber.dao.PersonDAO;
import com.netology.layerdaohiber.repository.LayerRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class LayerRepositoryImpl implements LayerRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<PersonDAO> getPersonsByCity(String city) {
        Query query = entityManager.createQuery("select p from PersonDAO p where p.cityOfLiving = :city");
        query.setParameter("city", city);
        List<PersonDAO> list = (List<PersonDAO>)query.getResultList();
        return list;
    }
}
