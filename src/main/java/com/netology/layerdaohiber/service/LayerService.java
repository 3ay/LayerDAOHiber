package com.netology.layerdaohiber.service;

import com.netology.layerdaohiber.dao.PersonDAO;

import java.util.List;
import java.util.Optional;

public interface LayerService {
    List<PersonDAO> getPersonsByCityOfLiving(String city);
    List<PersonDAO> getAll();
    List<PersonDAO> getPersonsWithLessAge(int age);
    Optional<PersonDAO> getPersonsByNameAndUsername(String name,String username);
}
