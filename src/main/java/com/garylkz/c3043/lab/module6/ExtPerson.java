package com.garylkz.c3043.lab.module6;

import com.garylkz.c3043.lab.module3.Date;
import com.garylkz.c3043.lab.module5.Person;

/*
Exercise
--------
- Define the class Address that can store a street address, city, state, and zip code. Use the
  appropriate methods to print and store the address. Also, use constructors to automatically
  initialize the data members.
- Define the class ExtPerson using the class Person, the class Date (as designed in Lab-Chapter3
  Part 1-Activity 1. You may modify it accordingly), and the class Address.
- Add extension classes to categorize the person as a family member, friend or business
  associate. Differentiate each class by adding its own possible data members. For example,
  business associate might have company information.
- Use constructors to automatically initialize the data members for each defined classes where
  applicable.
- Add (or override) methods to print and store the appropriate information based for each
  defined classes previously.

 */

public abstract class ExtPerson extends Person {
    private String category;
    private Date birthDate;

    public ExtPerson(String category, String name, Address address, String phone, Date birthDate) {
        super(name, address, phone);
        this.category = category;
        this.birthDate = birthDate;
    }

    public String getCategory() {
        return category;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String toString() {
        return super.toString() + "Birth Date: " + birthDate.toString() + "\nCategory: " + category + "\n";
    }
}

class Family extends ExtPerson {
    private String relation;

    public Family(String name, Address address, String phone, Date birthDate, String relation) {
        super("Family", name, address, phone, birthDate);
        this.relation = relation;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String toString() {
        return super.toString() + "Relation: " + relation + "\n";
    }
}

class Friend extends ExtPerson {
    private String note;

    public Friend(String name, Address address, String phone, Date birthDate, String note) {
        super("Friend", name, address, phone, birthDate);
        this.note = note;
    }
    
    public String getNote() {
        return note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    
    public String toString() {
        return super.toString() + "Note: " + note + "\n";
    }
}

class BusinessAssociate extends ExtPerson {
    private String company;
    private String position;

    public BusinessAssociate(String name, Address address, String phone, Date birthDate, String company, String position) {
        super("Business Associate", name, address, phone, birthDate);
        this.company = company;
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public String getPosition() {
        return position;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String toString() {
        return super.toString() + "Company: " + company + "\nPosition: " + position + "\n";
    }
}
