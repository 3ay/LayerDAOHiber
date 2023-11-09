package com.netology.layerdaohiber.controller;

import com.netology.layerdaohiber.dao.PersonDAO;
import com.netology.layerdaohiber.service.LayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class LayerController {
    private final LayerService service;

    @GetMapping("find/persons/by-city")
    public ResponseEntity<List<PersonDAO>> getPersonsByCityOfLiving(@RequestParam(value = "city") String city) {
        return ResponseEntity.ok(service.getPersonsByCityOfLiving(city));
    }

    @GetMapping("find/persons/less-age")
    public ResponseEntity<List<PersonDAO>> getPersonsWithLessAge(@RequestParam(value = "age") String age) {
        return ResponseEntity.ok(service.getPersonsWithLessAge(age));
    }

    @GetMapping("find/persons/name-and-surname")
    public ResponseEntity<Optional<PersonDAO>> getPersonsByNameAndSurname(@RequestParam(value = "name") String name,
                                                                          @RequestParam(value = "surname") String surname) {
        return ResponseEntity.ok(service.getPersonsByNameAndSurname(name, surname));
    }

}
