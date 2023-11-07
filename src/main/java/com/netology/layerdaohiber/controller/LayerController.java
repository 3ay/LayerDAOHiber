package com.netology.layerdaohiber.controller;

import com.netology.layerdaohiber.dao.PersonDAO;
import com.netology.layerdaohiber.repository.LayerRepository;
import com.netology.layerdaohiber.service.LayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LayerController {
    private final LayerService service;
    @GetMapping("/persons/by-city")
    public ResponseEntity<List<String>> getPersonsByCity(@RequestParam (value = "city") String city)
    {
        return ResponseEntity.ok(service.getPersonsByCity(city));
    }
}
