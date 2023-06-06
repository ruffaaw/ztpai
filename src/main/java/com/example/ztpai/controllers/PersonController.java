package com.example.ztpai.controllers;

import com.example.ztpai.model.Person;
import com.example.ztpai.repository.PersonCollectionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")
@CrossOrigin
public class PersonController {
    private final PersonCollectionRepository repository;

    @Autowired
    public PersonController(PersonCollectionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Person> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Integer id) {
        Optional<Person> person = repository.findById(id);
        if (person.isPresent()) {
            return ResponseEntity.ok(person.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found");
        }
    }

    @PostMapping("")
    public ResponseEntity<Void> create(@Valid @RequestBody Person person) {
        repository.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody Person person, @PathVariable Integer id) {
        Optional<Person> existingPerson = repository.findById(id);
        if (existingPerson.isPresent()) {
            repository.deleteById(id);

            person.setId(id);
            repository.save(person);

            return ResponseEntity.noContent().build();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found");
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Optional<Person> existingPerson = repository.findById(id);
        if (existingPerson.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found");
        }
    }
}

