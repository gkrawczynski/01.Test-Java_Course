package com.course.java.service;

import com.course.java.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
public class PersonService {
    List<Person> personList;

    public List<String> getOldestWomen(List<Person> personList) {
        if (personList == null) {
            throw new IllegalArgumentException();
        } else {
            Map<String, Integer> womenMap = new HashMap<>();
            List<String> oldestWomen = new ArrayList<>();

            int maxAge = Integer.MIN_VALUE;

            for (Person person : personList) {
                Pattern p = Pattern.compile("\\w*a$");
                Matcher m = p.matcher(person.getFirstName());
                boolean result = m.matches();
                if (result) {
                    int personAge = person.getAge();
                    if (maxAge < personAge) {
                        maxAge = personAge;
                    }
                    womenMap.put(person.getFirstName(), personAge);
                }
            }

            Set s = womenMap.entrySet();
            Iterator i = s.iterator();
            while (i.hasNext()) {
                Map.Entry mapEntry = (Map.Entry) i.next();
                int tmp = (int) mapEntry.getValue();
                if (tmp == maxAge) {
                    oldestWomen.add((String) mapEntry.getKey());
                }
            }

            return oldestWomen;
        }
    }


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


    public static int getAverageAgeOfAllMen(List<Person> personList) {
        if (personList == null) {
            throw new IllegalArgumentException();
        } else {
            int numberOfMen = 0;
            int sumMenAge = 0;

            for (Person person : personList) {
                if (PersonServiceHelper.getGender(person).equals("Male")) {
                    sumMenAge += person.getAge();
                    numberOfMen++;
                }
            }

            return sumMenAge / numberOfMen;
        }
    }


    public static int getAverageAgeOfAllWomen(List<Person> personList) {
        if (personList == null) {
            throw new IllegalArgumentException();
        } else {
            int numberOfWomen = 0;
            int sumWomenAge = 0;

            for (Person person : personList) {
                if (PersonServiceHelper.getGender(person).equals("Female")) {
                    sumWomenAge += person.getAge();
                    numberOfWomen++;
                }
            }

            return sumWomenAge / numberOfWomen;
        }
    }


    /* metode ktora agreguje dwie metody powyzej (tzn: jako drugi parametr przyjmuje funkcje ktora okresla plec) ??? */
    public int getAverageAge(List<Person> personList, String gender) {
        if (personList == null || gender == null) {
            throw new IllegalArgumentException();
        } else {
            int result = 0;

            List<Person> womenList = new ArrayList<>();
            List<Person> menList = new ArrayList<>();

            if (gender.equals("Female")) {
                for (Person p : personList) {
                    if (PersonServiceHelper.getGender(p).equals("Female"))
                        womenList.add(p);
                }
                result = PersonService.getAverageAgeOfAllWomen(womenList);
            } else {
                for (Person p : personList) {
                    if (PersonServiceHelper.getGender(p).equals("Male"))
                        menList.add(p);
                }
                result = PersonService.getAverageAgeOfAllMen(menList);
            }

            return result;
        }
    }


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
            Set s = cityMap.entrySet();
            Iterator i = s.iterator();
            int maxOccurance = Integer.MIN_VALUE;

            while (i.hasNext()) {
                Map.Entry mapEntry = (Map.Entry) i.next();
                int tmp = (int) mapEntry.getValue();
                if (maxOccurance < tmp) {
                    maxOccurance = tmp;
                }
            }

            /* Find most common Figure in the list of figures */
            Iterator it = s.iterator();
            while (it.hasNext()) {
                Map.Entry mapEntry = (Map.Entry) it.next();
                int tmp = (int) mapEntry.getValue();
                if (tmp == maxOccurance) {
                    result.add((String) mapEntry.getKey());
                }
            }

            return result;
        }
    }


    public Set<String> getAllCitiesOccurance(List<Person> personList) {
        if (personList == null) {
            throw new IllegalArgumentException();
        } else {
            Set<String> citySet = new HashSet<>();
            for (Person p : personList) {
                String tempCity = p.getCity();
                citySet.add(tempCity);
            }

            return citySet;
        }
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