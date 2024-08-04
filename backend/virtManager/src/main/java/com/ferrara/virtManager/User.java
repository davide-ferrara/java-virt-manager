package com.ferrara.virtManager;

import java.util.Date;

public abstract class User extends Person {
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    private int credits;
    // private boolean admin;

    public User() {
    }

    public User(String name, String lastname, Date dateOfBirth, String userName, String email,
            String password) {
        super(name, lastname, dateOfBirth);
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User(String name, String lastname, Date dateOfBirth, String address, String userName, String email,
            String password, String phoneNumber) {
        super(name, lastname, dateOfBirth, address);
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String toString() {
        return String.format("%s %s %s", getName(), getLastname(), getUserName());
    }

}
