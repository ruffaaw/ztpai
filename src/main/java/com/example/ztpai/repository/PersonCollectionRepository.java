package com.example.ztpai.repository;

import com.example.ztpai.model.Person;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonCollectionRepository {
    private final List<Person> personList = new ArrayList<>();

    public PersonCollectionRepository() {
    }

    public List<Person> findAll() {
        return personList;
    }

    public Optional<Person> findById(Integer id) {
        return personList.stream().filter(p -> p.id().equals(id)).findFirst();
    }

    public void save(Person person) {
        personList.removeIf(p -> p.id().equals(person.id()));
        personList.add(person);
    }

    @PostConstruct
    private void init() {
        Person person = new Person(1,
                "John",
                "Snow",
                "johnsnow",
                "1234541231");
        personList.add(person);
    }

    public boolean existsById(Integer id) {
        return personList.stream().filter(p -> p.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        personList.removeIf(p -> p.id().equals(id));
    }

}
