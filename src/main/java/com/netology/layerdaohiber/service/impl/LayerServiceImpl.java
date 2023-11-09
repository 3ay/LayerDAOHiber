package com.netology.layerdaohiber.service.impl;

import com.netology.layerdaohiber.dao.PersonDAO;
import com.netology.layerdaohiber.repository.LayerRepository;
import com.netology.layerdaohiber.service.LayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LayerServiceImpl implements LayerService {
    private final LayerRepository repository;

    @Override
    public List<PersonDAO> getPersonsByCityOfLiving(String city) {
        return repository.findAllByCityOfLiving(city);
    }

    @Override
    public List<PersonDAO> getPersonsWithLessAge(int age) {
        return repository.getPersonsWithLessAge(age);
    }

    @Override
    public Optional<PersonDAO> getPersonsByNameAndSurname(String name, String surname) {
        return repository.getPersonsByNameAndSurname(name, surname);
    }
}
