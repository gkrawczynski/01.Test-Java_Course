package com.course.java.service;

import com.course.java.model.Party;
import com.course.java.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class PartyServiceTest {
    private Party party;
    private PartyService partyService;
    private List<Person> peopleList;
    private Set<Person> friendsSet1;
    private Set<Person> friendsSet2;


    @Before
    public void setUp() throws Exception {
        party = new Party(peopleList);
        partyService = new PartyService();
        peopleList = initPeopleList();
        friendsSet1 = initFriendsSet1();
        friendsSet2 = initFriendsSet2();
    }

    private Set<Person> initFriendsSet1() {
        return Set.of(
                new Person("Jola", "Podolska", 48, "New York City"),
                new Person("Jackie", "Williams", 32, "San Diego", friendsSet2),
                new Person("Anna", "Jones", 28, "Chicago", friendsSet2),
                new Person("Sarah", "Miller", 41, "Miami", friendsSet2),
                new Person("Nick", "Davis", 37, "New York City", friendsSet2)
        );
    }

    private Set<Person> initFriendsSet2() {
        return Set.of(
                new Person("Monica", "McDonald", 21, "Denver", friendsSet1),
                new Person("Mark", "Gustafsson", 32, "San Diego", friendsSet1),
                new Person("Stephen", "King", 28, "Dallas", friendsSet1),
                new Person("Jeff", "MacKeef", 41, "Denver", friendsSet1),
                new Person("Jola", "Podolska", 48, "New York City")
        );
    }


    private List<Person> initPeopleList() {
        return List.of(
                new Person("John", "Kowalski", 21, "Denver", friendsSet1),
                new Person("Anna", "Nowak", 48, "San Diego", friendsSet2),
                new Person("Tom", "Brown", 28, "Chicago", friendsSet1),
                new Person("Magda", "Smith", 31, "Denver", friendsSet2),
                new Person("Jola", "Podolska", 48, "New York City")
        );
    }

    @Test
    public void hasSuperStar() {
        //given
        party.setPersonPartyList(peopleList);
        System.out.println(party.getPersonPartyList());

        //when
        boolean result = partyService.hasSuperStar(party);

        //then
        Assert.assertTrue(result);
    }
}