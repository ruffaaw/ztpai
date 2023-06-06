package com.example.ztpai.repository;

import com.example.ztpai.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PersonCollectionRepository {
    private final List<Person> persons = new ArrayList<>();

    public PersonCollectionRepository() {
    }

    public List<Person> findAll() {
        return persons;
    }

    public Optional<Person> findById(UUID id) {
        return persons.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    public void save(Person person) {
        persons.add(person);
    }

    public void deleteById(UUID id) {
        persons.removeIf(person -> person.getId().equals(id));
    }
}
