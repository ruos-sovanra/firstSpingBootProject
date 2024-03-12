package com.example.Application.service;

import com.example.Application.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PersonServiceImpl implements PersonService{
    private List<Person> personList = new ArrayList<>();

    @Override
    public List<Person> getAllPersons() {
        return personList;
    }

    @Override
    public Person getPersonById(Long id) {
        return personList.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
    }

    @Override
    public Person addPerson(Person person) {
        personList.add(person);
        return person;
    }

    @Override
    public Person updatePerson(Long id, Person personDetails) {
        Person person = getPersonById(id);
        person.setName(personDetails.getName());
        person.setEmail(personDetails.getEmail());
        return person;
    }

    @Override
    public void deletePerson(Long id) {
        personList.removeIf(person -> person.getId().equals(id));
    }
}
