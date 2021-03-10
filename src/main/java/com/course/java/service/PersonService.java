package com.course.java.service;

import com.course.java.NoWomenException;
import com.course.java.model.Person;
import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class PersonService {
    List<Person> personList;

    /* metoda, ktora zwraca najstarsza kobiete (imie konczy sie na 'a')
        lub NoWomenException jesli brak kobiet na liscie */
    public List<Person> getOldestWomen(List<Person> personList) throws NoWomenException {
        List<Person> women = new ArrayList<>();
        List<Person> oldestWomen = new ArrayList<>();

        if (personList == null || personList.isEmpty()) {
            throw new IllegalArgumentException("List is null or empty");
        }

        for (Person person : personList) {
            if (person.getGender().equals("Female")) {
                women.add(person);
            }
        }

        if (women.isEmpty()) {
            throw new NoWomenException("No women on list");
        }

        int maxAge = Integer.MIN_VALUE;
        for (Person woman : women) {
            if (woman.getAge() > maxAge) {
                maxAge = woman.getAge();
            }
        }
        for (Person woman : women) {
            if (woman.getAge() == maxAge) {
                oldestWomen.add(woman);
            }
        }

        return oldestWomen;
    }


    /* metoda, ktora zwraca sredni wiek wszystkich osob */
    public int getAverageAgeOfAllPeople(List<Person> personList) {
        if (personList == null) {
            throw new IllegalArgumentException();
        } else {
            int listSize = personList.size();
            int sumAllAge = 0;

            for (Person p : personList) {
                sumAllAge += p.getAge();
            }

            return sumAllAge / listSize;
        }
    }

    /*  metoda, ktora zwraca sredni wiek mezczyzn  */
    public static int getAverageAgeOfAllMen(List<Person> personList) {
        if (personList == null) {
            throw new IllegalArgumentException();
        } else {
            int numberOfMen = 0;
            int sumMenAge = 0;

            for (Person person : personList) {
                if (person.getGender().equals("Male")) {
                    sumMenAge += person.getAge();
                    numberOfMen++;
                }
            }

            return sumMenAge / numberOfMen;
        }
    }


    /* metoda, ktora zwrca sredni wiek kobiet */
    public static int getAverageAgeOfAllWomen(List<Person> personList) {
        if (personList == null) {
            throw new IllegalArgumentException();
        } else {
            int numberOfWomen = 0;
            int sumWomenAge = 0;

            for (Person person : personList) {
                if (person.getGender().equals("Female")) {
                    sumWomenAge += person.getAge();
                    numberOfWomen++;
                }
            }

            return sumWomenAge / numberOfWomen;
        }
    }


    /* metoda, ktora agreguje dwie metody powyzej (tzn: jako drugi parametr przyjmuje funkcje ktora okresla plec) */
    public int getAverageAge(List<Person> personList, String gender) {
        if (personList == null || gender == null) {
            throw new IllegalArgumentException();
        } else {
            int result = 0;

            List<Person> womenList = new ArrayList<>();
            List<Person> menList = new ArrayList<>();

            if (gender.equals("Female")) {
                for (Person p : personList) {
                    if (p.getGender().equals("Female"))
                        womenList.add(p);
                }
                result = PersonService.getAverageAgeOfAllWomen(womenList);
            } else {
                for (Person p : personList) {
                    if (p.getGender().equals("Male"))
                        menList.add(p);
                }
                result = PersonService.getAverageAgeOfAllMen(menList);
            }

            return result;
        }
    }


    /* metoda, ktora znajdze miasto w ktorym zyje najwiecej ludzi */
    public List<String> getTheMostPopulatedCities(List<Person> personList) {
        if (personList == null) {
            throw new IllegalArgumentException();
        } else {
            List<String> result = new ArrayList<>();

            Map<String, Integer> cityMap = new HashMap<>();
            for (Person p : personList) {
                String tempCity = p.getCity();
                if (!cityMap.containsKey(tempCity)) {
                    cityMap.put(tempCity, 1);
                } else {
                    cityMap.put(tempCity, cityMap.get(tempCity) + 1);
                }
            }

            /* Find max Value in the Map */
            int maxOccurance = Integer.MIN_VALUE;
            for (Map.Entry<String, Integer> stringIntegerMap1 : cityMap.entrySet()) {
                int temp = stringIntegerMap1.getValue();
                if (maxOccurance < temp) {
                    maxOccurance = temp;
                }
            }

            /* Find most populated cities */
            for (Map.Entry<String, Integer> stringIntegerMap2 : cityMap.entrySet()) {
                int tmp = stringIntegerMap2.getValue();
                if (tmp == maxOccurance) {
                    result.add(stringIntegerMap2.getKey());
                }
            }

            return result;
        }
    }


    /* metoda, ktora zwroci wszystkie rozne miasta z listy osob (rozne tzn: bez powtorzen) */
    public Set<String> getAllCitiesOccurance(List<Person> personList) {
        if (personList == null) {
            throw new IllegalArgumentException();
        }

        Set<String> citySet = new HashSet<>();
        for (Person p : personList) {
            String tempCity = p.getCity();
            citySet.add(tempCity);
        }

        return citySet;
    }
}
/*
Zadanie02:
Stworz sobie klase Osoba (imie, nazwisko, miasto, wiek)
 - metoda co zwraca najstarsza kobiete (imie konczy sie na 'a')
 - lub NoWomenException jesli brak kobiet na liscie
 - metode ktora zwraca sredni wiek wszystkich osob
 - metode ktora zwraca sredni wiek mezczyzn
 - metode ktora zwrca sredni wiek kobiet
 - metode ktora agreguje dwie metody powyzej (tzn: jako drugi parametr przyjmuje funkcje ktora okresla plec) ???
 - metode ktora znajdze miasto w ktorym zyje najwiecej ludzi
 - metode ktora zwroci wszystkie rozne miasta z listy osob (rozne tzn: bez powtorzen)
 */