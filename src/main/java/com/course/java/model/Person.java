package com.course.java.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String city;
    private Set<Person> friendsSet;

    public Person() {
    }

    public Person(String firstName, String lastName, int age, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
    }

    public Person(String firstName, String lastName, int age, String city, Set<Person> friendsSet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
        if (friendsSet != null) {
            this.friendsSet = friendsSet;
        } else {
            this.friendsSet = new HashSet<>();
        }
    }

}

