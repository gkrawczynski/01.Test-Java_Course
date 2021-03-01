package com.course.java.service;

import com.course.java.model.Person;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonServiceHelper {

    public static String getGender(Person person) {
        if (person == null) {
            throw new IllegalArgumentException();
        } else {
            String result = "";
                Pattern pt = Pattern.compile("\\w*a$");
                Matcher m = pt.matcher(person.getFirstName());
                boolean b = m.matches();
                if (b) {
                    result = "Female";
                } else {
                    result = "Male";
                }
            return result;
        }
    }
}