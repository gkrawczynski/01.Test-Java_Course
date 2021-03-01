package com.course.java.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
public class Person {
    String firstName;
    String lastName;
    int age;
    String city;
    Set<Person> friendsSet;

    public Person(String firstName, String lastName, int age, String city, Set<Person> friendsSet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
        this.friendsSet = friendsSet;
    }

    public Person(String firstName, String lastName, int age, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
    }
}

