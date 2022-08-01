package com.thisgary.c3043.lab.module5;

import com.thisgary.c3043.lab.module6.Address;

import java.util.Date;

public class Person {
    private String name;
    private String address;
    private Address objAddress;
    private String phone;

    public Person(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Person(String name, Address address, String phone) {
        this.name = name;
        this.address = address.toString();
        this.objAddress = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Address getObjAddress() {
        return objAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setObjAddress(Address address) {
        this.address = address.toString();
        this.objAddress = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "Name: " + name + "\nAddress: " + address + "\nPhone: " + phone + "\n";
    }

    public static void main(String[] args) {
        Person person = new Person("John", "17, George Road, 1140, George, Uganda", "123456789");
        System.out.println(person);
        Employee employee = new Employee("John", "17, George Road, 1140, George, Uganda", "123456789",
                "123456789", "Astrology", "CEO", 8888, new Date());
        System.out.println(employee);
        Student student = new Student("John", "17, George Road, 1140, George, Uganda", "123456789",
                "123456789", "Astrology", 2048);
        System.out.println(student);
        Alumni alumni = new Alumni("John", "17, George Road, 1140, George, Uganda", "123456789",
                "123456789", "Astrology", 2048, new Date());
        System.out.println(alumni);
    }
}

class Employee extends Person {
    private String id;
    private String department;
    private String position;
    private int salary;
    private Date hireDate;

    public Employee(String name, String address, String phone, String id, String department, String position, int salary, Date hireDate) {
        super(name, address, phone);
        this.id = id;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public String getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String toString() {
        return super.toString() + "\nID: " + id + "\nDepartment: " + department + "\nPosition: " + position + "\nSalary: " + salary + "\nHire Date: " + hireDate + "\n";
    }
}

class Student extends Person {
    private String id;
    private String major;
    private int year;

    public Student(String name, String address, String phone, String id, String major, int year) {
        super(name, address, phone);
        this.id = id;
        this.major = major;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getMajor() {
        return major;
    }

    public int getYear() {
        return year;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return super.toString() + "\nID: " + id + "\nMajor: " + major + "\nYear: " + year + "\n";
    }
}

class Alumni extends Student {
    private Date graduationDate;

    public Alumni(String name, String address, String phone, String id, String major, int year, Date graduationDate) {
        super(name, address, phone, id, major, year);
        this.graduationDate = graduationDate;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String toString() {
        return super.toString() + "\nGraduation Date: " + graduationDate + "\n";
    }
}

class Academician extends Employee {
    public Academician(String name, String address, String phone, String id, String department, String position, int salary, Date hireDate, String university) {
        super(name, address, phone, id, department, position, salary, hireDate);
    }
}

class Administration extends Employee {
    public Administration(String name, String address, String phone, String id, String department, String position, int salary, Date hireDate, String university) {
        super(name, address, phone, id, department, position, salary, hireDate);
    }
}

class Undergraduate extends Student {
    private Date undergraduateDate;

    public Undergraduate(String name, String address, String phone, String id, String major, int year, Date undergraduateDate) {
        super(name, address, phone, id, major, year);
        this.undergraduateDate = undergraduateDate;
    }

    public Date getUndergraduateDate() {
        return undergraduateDate;
    }

    public void setUndergraduateDate(Date undergraduateDate) {
        this.undergraduateDate = undergraduateDate;
    }

    public String toString() {
        return super.toString() + "\nUndergraduate Date: " + undergraduateDate + "\n";
    }
}

class Postgraduate extends Student {
    private Date postgraduateDate;

    public Postgraduate(String name, String address, String phone, String id, String major, int year, Date postgraduateDate) {
        super(name, address, phone, id, major, year);
        this.postgraduateDate = postgraduateDate;
    }

    public Date getPostgraduateDate() {
        return postgraduateDate;
    }

    public void setPostgraduateDate(Date postgraduateDate) {
        this.postgraduateDate = postgraduateDate;
    }

    public String toString() {
        return super.toString() + "\nPostgraduate Date: " + postgraduateDate + "\n";
    }
}

class Doctral extends Postgraduate {
    private String thesis;

    public Doctral(String name, String address, String phone, String id, String major, int year, Date postgraduateDate, String thesis) {
        super(name, address, phone, id, major, year, postgraduateDate);
        this.thesis = thesis;
    }

    public String getThesis() {
        return thesis;
    }

    public void setThesis(String thesis) {
        this.thesis = thesis;
    }
}

class Masters extends Postgraduate {
    private String thesis;

    public Masters(String name, String address, String phone, String id, String major, int year, Date postgraduateDate, String thesis) {
        super(name, address, phone, id, major, year, postgraduateDate);
        this.thesis = thesis;
    }

    public String getThesis() {
        return thesis;
    }

    public void setThesis(String thesis) {
        this.thesis = thesis;
    }
}
