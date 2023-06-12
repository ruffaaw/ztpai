package com.example.ztpai;

import com.example.ztpai.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class JpaPersonTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    public void testJpa(){
        Person person = new Person();
        person.setEmail("walterwhiter@gmail.com");
        person.setName("Walter");
        person.setSurname("White");
        person.setPassword("IamTheDanger!");
        person.setPhone("123452342");

        entityManager.persist(person);

        UUID personId = person.getId();
        Person retrievedPerson = entityManager.find(Person.class, personId);

        System.out.println(retrievedPerson);
    }
}
