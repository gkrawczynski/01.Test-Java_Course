package com.course.java.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Party {
    List<Person> personPartyList;

    public Party(List<Person> personPartyList) {
        if (personPartyList != null) {
            this.personPartyList = personPartyList;
        } else {
            this.personPartyList = new ArrayList<>();
        }
    }
}
