package com.example.Application.service;

import com.example.Application.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons();
    Person getPersonById(Long id);
    Person addPerson(Person person);
    Person updatePerson(Long id, Person personDetails);
    void deletePerson(Long id);
}
