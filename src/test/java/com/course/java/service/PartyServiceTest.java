package com.course.java.service;

import com.course.java.model.Party;
import com.course.java.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class PartyServiceTest {
    private Party party;
    private PartyService partyService;
    private List<Person> peopleList;
    private Set<Person> friendsSet1;
    private Set<Person> friendsSet2;
    private Set<Person> friendsSet3;


    @Before
    public void setUp() throws Exception {
        party = new Party(peopleList);
        partyService = new PartyService();
        peopleList = initPeopleList();
        friendsSet1 = initFriendsSet1();
        friendsSet2 = initFriendsSet2();
        friendsSet3 = initFriendsSet3();
    }

    private Set<Person> initFriendsSet1() {
        return Set.of(
                new Person("Jola", "Podolska", 48, "New York City", initFriendsSet3()),
                new Person("Jackie", "Williams", 32, "San Diego", initFriendsSet3()),
                new Person("Anna", "Jones", 28, "Chicago", initFriendsSet3()),
                new Person("Sarah", "Miller", 41, "Miami", initFriendsSet3()),
                new Person("Nick", "Davis", 37, "New York City", initFriendsSet3())
        );
    }

    private Set<Person> initFriendsSet2() {
        return Set.of(
                new Person("Monica", "McDonald", 21, "Denver", initFriendsSet3()),
                new Person("Mark", "Gustafsson", 32, "San Diego", initFriendsSet3()),
                new Person("Stephen", "King", 28, "Dallas", initFriendsSet3()),
                new Person("Jeff", "MacKeef", 41, "Denver", initFriendsSet3()),
                new Person("Jola", "Podolska", 48, "New York City", initFriendsSet3())
        );
    }

    private Set<Person> initFriendsSet3() {
        return Set.of(
        );
    }


    private List<Person> initPeopleList() {
        return List.of(
                new Person("John", "Kowalski", 21, "Denver", initFriendsSet1()),
                new Person("Anna", "Nowak", 48, "San Diego", initFriendsSet2()),
                new Person("Tom", "Brown", 28, "Chicago", initFriendsSet1()),
                new Person("Magda", "Smith", 31, "Denver", initFriendsSet2()),
                new Person("Jola", "Podolska", 48, "New York City", initFriendsSet3())
        );
    }

    @Test
    public void shouldReturnIfHasSuperStar() {
        //given
        Party p = new Party(peopleList);

        //when
        boolean result = partyService.hasSuperStar(p);

        //then
        Assert.assertTrue(result);
    }
}