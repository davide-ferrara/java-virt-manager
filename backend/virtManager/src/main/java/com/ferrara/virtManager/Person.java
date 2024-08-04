package com.ferrara.virtManager;

import java.util.Date;

public abstract class Person {
    private String name;
    private String lastname;
    private Date dateOfBirth;
    private String nationality;
    private String address;

    public Person() {
    }

    public Person(String name, String lastname, Date dateOfBirth) {
        this.name = name;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(String name, String lastname, Date dateOfBirth, String address) {
        this.name = name;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}
