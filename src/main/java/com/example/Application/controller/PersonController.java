package com.example.Application.controller;

import com.example.Application.model.Person;
import com.example.Application.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listPersons", personService.getAllPersons());
        return "index";
    }

    @GetMapping("/add")
    public String addPersonPage() {
        return "addPerson";
    }

    @PostMapping("/add")
    public String addPerson(Person person) {
        personService.addPerson(person);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("person", personService.getPersonById(id));
        return "editPerson";
    }

    @PostMapping("/update/{id}")
    public String updatePerson(@PathVariable("id") Long id, Person personDetails) {
        personService.updatePerson(id, personDetails);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        personService.deletePerson(id);
        return "redirect:/";
    }

}
