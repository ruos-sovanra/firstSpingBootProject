package com.example.Application.controller;

import com.example.Application.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PersonController {
    private List<Person> personList = new ArrayList<>();

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listPersons", personList);
        return "index";
    }
    @GetMapping("/add")
    public String addPersonPage() {
        return "addPerson";
    }

    @PostMapping("/add")
    public String addPerson(Person person) {
        System.out.println("Adding person: " + person.getName());
        personList.add(person);
        System.out.println("Person added: " + person.getName());
        return "redirect:/";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Person person = findPersonById(id);
        model.addAttribute("person", person);
        return "editPerson";
    }

    @PostMapping("/update/{id}")
    public String updatePerson(@PathVariable("id") Long id, Person personDetails) {
        Person person = findPersonById(id);
        person.setName(personDetails.getName());
        person.setEmail(personDetails.getEmail());
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        personList.removeIf(person -> person.getId().equals(id));
        return "redirect:/";
    }

    private Person findPersonById(Long id) {
        return personList.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
    }

}
