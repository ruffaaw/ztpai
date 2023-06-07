package com.example.ztpai.service;

import com.example.ztpai.model.Person;
import com.example.ztpai.repository.PersonCollectionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonCollectionRepository personCollectionRepository;


    public PersonService(PersonCollectionRepository personCollectionRepository) {
        this.personCollectionRepository = personCollectionRepository;
    }

    public List<Person> getAllPersons() {
        return personCollectionRepository.findAll();
    }

    public Person getPersonById(UUID id) {
        Optional<Person> optionalPerson = personCollectionRepository.findById(id);
        return optionalPerson.orElse(null);
    }

    public Person createPerson(Person person) {
        return personCollectionRepository.save(person);
    }

    public Person updatePerson(UUID id, Person updatedPerson) {
        Optional<Person> optionalPerson = personCollectionRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setEmail(updatedPerson.getEmail());
            person.setName(updatedPerson.getName());
            person.setSurname(updatedPerson.getSurname());
            person.setPassword(updatedPerson.getPassword());
            person.setPhone(updatedPerson.getPhone());
            return personCollectionRepository.save(person);
        } else {
            return null;
        }
    }

    public boolean deletePerson(UUID id) {
        Optional<Person> optionalPerson = personCollectionRepository.findById(id);
        if (optionalPerson.isPresent()) {
            personCollectionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


}
