package com.garylkz.c3043.project.s63683;

// Deprecated, refer com.tzftgf.system.s62079.core.Customer instead.

public class Register {
    private String username;
    private String password;
    private String fullName;
    private String ic_no;
    private String address;
    private BirthDate birthdate;
    private Age age;

    public Register(String username, String password, String fullName, String ic_no, BirthDate birthdate, Age age, String address) {
        setUsername(username);
        setFullName(fullName);
        setIc_no(ic_no);
        setAddress(address);
        setBirthdate(birthdate);
        setAge(age);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getIc_no() {
        return ic_no;
    }

    public BirthDate getBirthdate() {
        return birthdate;
    }

    public Age getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setIc_no(String ic_no) {
        this.ic_no = ic_no;
    }

    public void setBirthdate(BirthDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String toString() {
        return String.format("Full Name: %s\n"
                + "Birthday: %s\n"
                + "Age: %s\n"
                + "Ic no.: %s\n"
                + "Address: %s\n", getFullName(), getBirthdate(), getAge(), getIc_no(), getAddress());
    }


}
