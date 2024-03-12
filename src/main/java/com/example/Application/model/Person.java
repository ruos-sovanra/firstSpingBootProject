package com.example.Application.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter


public class Person {
    private static long nextId = 1;
    private Long id;
    private String name;
    private String email;
    public Person() {
        this.id = nextId++;
    }
}
