package com.ferrara.virtManager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import jakarta.validation.Valid;

import com.ferrara.virtManager.entity.Person;
import com.ferrara.virtManager.repository.PersonRepository;

import com.ferrara.virtManager.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/person")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/personById")
    public List<Person> getPersonById(@RequestParam(name = "id") Long personID) {
        Optional<Person> person = personRepository.findById(personID);

        return List.of(person.get());
    }

}