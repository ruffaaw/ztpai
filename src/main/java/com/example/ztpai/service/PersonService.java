package com.example.ztpai.service;

import com.example.ztpai.model.Person;
import com.example.ztpai.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PersonService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(UUID id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        return optionalPerson.orElse(null);
    }

    public Person createPerson(Person person) {
        String hashedPassword = passwordEncoder.encode(person.getPassword());
        person.setPassword(hashedPassword);

        return personRepository.save(person);
    }

    public Person updatePerson(UUID id, Person updatedPerson) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setEmail(updatedPerson.getEmail());
            person.setName(updatedPerson.getName());
            person.setSurname(updatedPerson.getSurname());
            person.setPassword(updatedPerson.getPassword());
            person.setPhone(updatedPerson.getPhone());
            return personRepository.save(person);
        } else {
            return null;
        }
    }

    public boolean deletePerson(UUID id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            personRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Person login(String email, String password) {
        Person person = personRepository.findByEmail(email);
        if (person != null && passwordEncoder.matches(password, person.getPassword())) {
            return person;
        }
        return null;
    }
}
