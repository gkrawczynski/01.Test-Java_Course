package com.course.java.service;

import com.course.java.model.Party;
import com.course.java.model.Person;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class PartyService {

//    public PartyService(List<Person> peopleList) {
//    }

    public boolean hasSuperStar(Party party) {
        if (party == null){
            throw new IllegalArgumentException();
        } else {
            List<Person> partyPeopleList = party.getPersonPartyList();
            int partyPeopleListSize = partyPeopleList.size();
            Person potentialStar;
            String potentialStarFullName = "";

            int counter = 0;
            for (Person person : partyPeopleList) {
                if (person.getFriendsSet().isEmpty()) {
                    potentialStar = person;
                    potentialStarFullName = person.getFirstName() + " " + person.getLastName();
                    for (Person p : partyPeopleList) {
                        if (p.getFriendsSet().contains(potentialStar)) {
                            counter++;
                        }
                    }
                }
            }

            if (!potentialStarFullName.isEmpty() && counter == partyPeopleListSize - 1){
                System.out.println(potentialStarFullName);
                return true;
            } else {
                return false;
            }
        }

    }
}

/*
Zadanie 03:
napisz metode boolean hasSuperStar(Party party) ktora sprawdza czy na imprezie zajduje sie gwiazda
gwiazda to osoba ktora nie zna nikogo, ale wszyscy znaja gwiazde.
na imprezie jest lista Osob (Person[name]) i kazdy Person ma Set znajomych Set<Person>
 */