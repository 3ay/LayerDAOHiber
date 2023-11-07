package com.netology.layerdaohiber.repository;

import com.netology.layerdaohiber.dao.PersonDAO;

import java.util.List;

public interface LayerRepository {
    List<PersonDAO> getPersonsByCity(String city);
}
