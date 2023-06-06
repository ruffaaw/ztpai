package com.example.ztpai.repository;

import com.example.ztpai.model.Person;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonCollectionRepository {
    private final List<Person> persons = new ArrayList<>();

    public PersonCollectionRepository() {
        init();
    }

    public List<Person> findAll() {
        return persons;
    }

    public Optional<Person> findById(Integer id) {
        return persons.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    public void save(Person person) {
        persons.add(person);
    }

    public void deleteById(Integer id) {
        persons.removeIf(person -> person.getId().equals(id));
    }

    private void init() {
        Person person1 = new Person(1, "john.doe@example.com", "John", "Doe", "password1", "123456789");
        Person person2 = new Person(2, "jane.doe@example.com", "Jane", "Doe", "password2", "987654321");

        persons.add(person1);
        persons.add(person2);
    }
}
