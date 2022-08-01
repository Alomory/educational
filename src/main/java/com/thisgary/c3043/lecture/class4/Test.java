package com.thisgary.c3043.lecture.class4;

public class Test {
    public static void main(String[] args) {
        Person john = new Person("John", 'M', 30);
        Person jane = new Person("Jane", 'F', 25);
        Person jack = new Person("Jack", 'M', 20);
        Person jill = new Person("Jill", 'F', 18);

//        Country country = new Country("Country");
//        country.addPerson(john);
//        country.addPerson(jane);
//        country.addPerson(jack);
//        country.addPerson(jill);

        Country country = new Country("Country", john, jane, jack, jill);

//        Country country = new Country("Country");
//        country.setPeople(john, jane, jack, jill);

        country.getPeople().stream().forEach(System.out::println);

        University u1 = new University("University Umbrella");
        u1.addStudent("Omar", 'M', 20);
        u1.addStudent("John", 'M', 20);
        u1.addStudent("Jane", 'F', 20);
        System.out.println(u1);
    }
}
