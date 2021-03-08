package com.course.java.service;

import com.course.java.model.Person;

public class PersonServiceHelper {

    public static String getGender(Person person) {
        if (person == null) {
            throw new IllegalArgumentException();
        }

        String result = "";
        if (person.getFirstName().endsWith("a")) {
            result = "Female";
        } else {
            result = "Male";
        }

        return result;
    }
}