package com.netology.layerdaohiber.service.impl;

import com.netology.layerdaohiber.dao.PersonDAO;
import com.netology.layerdaohiber.repository.LayerRepository;
import com.netology.layerdaohiber.service.LayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LayerServiceImpl implements LayerService {
    private final LayerRepository repository;

    @Override
    public List<String> getPersonsByCity(String city) {
        List<String> persons = new ArrayList<>();
        List<PersonDAO> personDAOS = repository.getPersonsByCity(city);
        for (PersonDAO p : personDAOS) {
            persons.add(p.toString());
        }
        return persons;
    }
}
