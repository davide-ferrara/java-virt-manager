package com.ferrara.virtManager.entity;

import java.util.Date;

import org.hibernate.annotations.Comment;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
@Comment("Named users since user is a reserved key in SQL")
public class User extends Person {
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    private int credits;
    // private boolean admin;

    public User() {
    }

    public User(String firstName, String password) {
        super(firstName);
        this.password = password;
    }

    public User(String name, String lastname, Date dateOfBirth, String userName, String email,
            String password) {
        super(name, lastname, dateOfBirth);
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User(String firstName, String lastname, Date dateOfBirth, String address, String userName, String email,
            String password, String phoneNumber) {
        super(firstName, lastname, dateOfBirth, address);
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "user_name", nullable = false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "phone_number", nullable = true)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "credits", nullable = false)
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "User [id =" + getId() + " userName=" + userName + " email=" + email + " phoneNumber=" + phoneNumber
                + " credits=" + credits
                + "]";
    }

}
