package com.course.java.service;

import com.course.java.model.Party;
import com.course.java.model.Person;

import java.util.List;

public class PartyService {

    public boolean hasSuperStar(Party party) {
        if (party == null) {
            throw new IllegalArgumentException();
        }

        List<Person> partyPeopleList = party.getPersonPartyList();
        int partyPeopleListSize = partyPeopleList.size();

        int counter = 0;
        for (Person person : partyPeopleList) {
            if (person.getFriendsSet().isEmpty()) {
                for (Person p : partyPeopleList) {
                    if (p.getFriendsSet().contains(person)) {
                        counter++;
                    }
                }
            }
        }

        if (counter == partyPeopleListSize - 1) {
            return true;
        }

        return false;
    }

}
/*
Zadanie 03:
napisz metode boolean hasSuperStar(Party party) ktora sprawdza czy na imprezie zajduje sie gwiazda
gwiazda to osoba ktora nie zna nikogo, ale wszyscy znaja gwiazde.
na imprezie jest lista Osob (Person[name]) i kazdy Person ma Set znajomych Set<Person>
 */