package com.example.ztpai.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "person", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Person {
        @GeneratedValue(strategy = GenerationType.UUID)
        @Id
        @Column(name = "id")
        private UUID id;
        @NotBlank(message = "Email cannot be empty")
        @Email(message = "Invalid email format")
        @Column(name = "email")
        private String email;
        @Column(name="name")
        private String name;
        @Column(name="surname")
        private String surname;
        @Column(name="password")
        @NotBlank(message = "Password cannot be empty")
        private String password;
        @Column(name="phone")
        private String phone;

        public Person() {
        }

        public Person(UUID id, String email, String name, String surname, String password, String phone) {
                this.id = id;
                this.email = email;
                this.name = name;
                this.surname = surname;
                this.password = password;
                this.phone = phone;
        }

        public UUID getId() {
                return id;
        }

        public void setId(UUID id) {
                this.id = id;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getSurname() {
                return surname;
        }

        public void setSurname(String surname) {
                this.surname = surname;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        @Override
        public String toString() {
                return "Person{" +
                        "id=" + id +
                        ", email='" + email + '\'' +
                        ", name='" + name + '\'' +
                        ", surname='" + surname + '\'' +
                        ", password='" + password + '\'' +
                        ", phone='" + phone + '\'' +
                        '}';
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Person person = (Person) o;
                return Objects.equals(id, person.id) && Objects.equals(email, person.email) && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(password, person.password) && Objects.equals(phone, person.phone);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, email, name, surname, password, phone);
        }
}
