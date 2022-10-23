package com.garylkz.c3043.lecture.class4;

import java.util.ArrayList;
import java.util.List;

public class Country {
    private String name;
    private List<Person> people = new ArrayList<>();

    public Country(String name) {
        this.name = name;
    }

    public Country(String name, Person... people) {
        this(name);
        setPeople(people);
    }


    public void addPerson(Person person) {
        people.add(person);
    }

    public void removePerson(Person person) {
        people.remove(person);
    }

    public String getName() {
        return name;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPeople(Person... people) {
        for (Person person : people) if (!getPeople().contains(person)) addPerson(person);
    }
}
