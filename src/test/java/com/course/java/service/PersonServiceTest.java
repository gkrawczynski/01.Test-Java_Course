package com.course.java.service;

import com.course.java.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class PersonServiceTest {
    private PersonService personService;
    private List<Person> peopleList;
    private Set<Person> friendsSet1;
    private Set<Person> friendsSet2;


    @Before
    public void setUp() throws Exception {
        personService = new PersonService(peopleList);
        peopleList = initPeopleList();
        friendsSet1 = initFriendsSet1();
        friendsSet2 = initFriendsSet2();
    }

    private Set<Person> initFriendsSet1() {
        return Set.of(
                new Person("Angelina", "Johnson", 21, "Denver", friendsSet2),
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
                new Person("Robert", "Garcia", 37, "New York City", friendsSet1)
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
    public void shouldReturnOldestWoman() {
        //given
        List<Person> result1 = List.of(
                new Person("Anna", "Nowak", 48, "San Diego"),
                new Person("Jola", "Podolska", 48, "New York City")
        );

        List<Person> result2 = List.of(
                new Person("Magda", "Smith", 31, "Denver"),
                new Person("Magda", "Smith", 31, "Denver")
        );

        List<Person> result3 = List.of();

        //when
        List<Person> oldestWomen = personService.getOldestWomen(peopleList);
        List<Person> oldestWomen2 = personService.getOldestWomen(peopleList);

        //then
        Assert.assertEquals(result1, oldestWomen);
        Assert.assertNotEquals(result2, oldestWomen);
        Assert.assertNotEquals(result3, oldestWomen2);
        System.out.println("OldestWomen: " + oldestWomen);
    }


    @Test
    public void shouldReturnAverageAgeOfAllPeople() {
        //given
        int averageAgeOfAllPeople1 = 35;
        int averageAgeOfAllPeople2 = 25;

        //when
        int result = personService.getAverageAgeOfAllPeople(peopleList);

        //then
        Assert.assertEquals(averageAgeOfAllPeople1, result, 0);
        Assert.assertNotEquals(averageAgeOfAllPeople2, result, 0);
        System.out.println("AvgAll: " + result);
    }


    @Test
    public void shouldReturnAverageAgeOfAllMen() {
        //given
        int averageMenAge1 = 24;
        int averageMenAge2 = 44;

        //when
        int result = personService.getAverageAgeOfAllMen(peopleList);

        //then
        Assert.assertEquals(averageMenAge1, result, 0);
        Assert.assertNotEquals(averageMenAge2, result, 0);
        System.out.println("AvgMen: " + result);
    }


    @Test
    public void shouldReturnAverageAgeOfAllWomen() {
        //given
        int averageWomenAge1 = 42;
        int averageWomenAge2 = 52;

        //when
        double result = personService.getAverageAgeOfAllWomen(peopleList);

        //then
        Assert.assertEquals(averageWomenAge1, result, 0);
        Assert.assertNotEquals(averageWomenAge2, result, 0);
        System.out.println("AvgWomen: " + result);
    }


    @Test
    public void shouldReturnAverageAge() {
        //given
        int averageAge1 = 42;
        int averageAge2 = 62;

        //when
        String gender = "Female";
        int result = personService.getAverageAge(peopleList, gender);

        //then
        Assert.assertEquals(averageAge1, result);
        Assert.assertNotEquals(averageAge2, result);
        System.out.println("Average age for " + gender + ": " + result);
    }


    @Test
    public void shouldReturnTheMostPopulatedCities() {
        //given
        List<String> mostPopulatedCity1 = List.of("Denver");
        List<String> mostPopulatedCity2 = List.of("London");

        //when
        List<String> result = personService.getTheMostPopulatedCities(peopleList);

        //then
        Assert.assertEquals(mostPopulatedCity1, result);
        Assert.assertNotEquals(mostPopulatedCity2, result);
        System.out.println("Most populated city: " + result);
    }


    @Test
    public void shouldReturnAllCitiesOccurance() {
        //given
        Set<String> allCities1 = Set.of("New York City", "San Diego", "Chicago", "Denver");
        Set<String> allCities2 = Set.of("New Jersey", "San Jose", "Michigan", "Sacramento");

        //when
        Set<String> result = personService.getAllCitiesOccurance(peopleList);

        //then
        Assert.assertEquals(allCities1, result);
        Assert.assertNotEquals(allCities2, result);
        System.out.println(result);
    }
}