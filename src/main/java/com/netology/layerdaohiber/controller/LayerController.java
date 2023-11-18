package com.netology.layerdaohiber.controller;

import com.netology.layerdaohiber.dao.PersonDAO;
import com.netology.layerdaohiber.service.LayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class LayerController {
    private final LayerService service;

    @GetMapping("find/persons/by-city")
    @Secured("ROLE_READ")
    public ResponseEntity<List<PersonDAO>> getPersonsByCityOfLiving(@RequestParam(value = "city") String city) {
        return ResponseEntity.ok(service.getPersonsByCityOfLiving(city));
    }

    @GetMapping("find/persons/less-age")
    @RolesAllowed("ROLE_WRITE")
    public ResponseEntity<List<PersonDAO>> getPersonsWithLessAge(@RequestParam(value = "age") int age) {
        return ResponseEntity.ok(service.getPersonsWithLessAge(age));
    }

    @GetMapping("find/persons/all")
    @PreAuthorize("hasRole('WRITE') or hasRole('DELETE')")
    public ResponseEntity<List<PersonDAO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("find/persons/name-and-username")
    @PreAuthorize("#username == authentication.principal.username")
    public ResponseEntity<Optional<PersonDAO>> getPersonsByNameAndUsername(@RequestParam(value = "name") String name,
                                                                          @RequestParam(value = "username") String username) {
        return ResponseEntity.ok(service.getPersonsByNameAndUsername(name, username));
    }


}
