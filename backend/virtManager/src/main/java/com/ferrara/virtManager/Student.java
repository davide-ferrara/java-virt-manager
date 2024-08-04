package com.ferrara.virtManager;

import java.util.Date;

public class Student extends User {
    private int studentID;
    private int academicYear;
    private int expGraduationYear;
    private int credits = 50;

    public Student() {
        // Costruttore predefinito necessario per la deserializzazione
    }

    public Student(String name, String lastname) {
        super(name, lastname);
    }

    public Student(String name, String lastname, int studentID) {
        super(name, lastname);
        this.studentID = studentID;
    }

    public Student(String name, String lastname, Date dateOfBirth, String address, String userName, String email,
            String password, String phoneNumber, int studentID) {
        super(name, lastname, dateOfBirth, address, userName, email, password, phoneNumber);
        this.studentID = studentID;
    }

    public Student(String name, String lastname, Date dateOfBirth, String address, String userName, String email,
            String password, String phoneNumber, int studentID, int academicYear,
            int expGraduationYear) {
        super(name, lastname, dateOfBirth, address, userName, email, password, phoneNumber);
        this.studentID = studentID;
        this.academicYear = academicYear;
        this.expGraduationYear = expGraduationYear;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public int getExpGraduationYear() {
        return expGraduationYear;
    }

    public void setExpGraduationYear(int expGraduationYear) {
        this.expGraduationYear = expGraduationYear;
    }

    public int getCredtis() {
        return this.credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return String.format("Name: %s \nlastname: %s \nStudentID: %d \nUsername: %s \nEmail: %s \nCredits: %d",
                getName(),
                getLastname(), getStudentID(), getUserName(), getEmail(),
                getCredtis());
    }

}
