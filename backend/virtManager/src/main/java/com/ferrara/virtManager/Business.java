package com.ferrara.virtManager;

import java.util.Date;

public class Business extends User {
    private String businessName;
    private int credits = 0;

    public Business(String name, String lastname, Date dateOfBirth, String address, String userName, String email,
            String password, String phoneNumber, String companyName, String companyAddress, String businessName) {
        super(name, lastname, dateOfBirth, address, userName, email, password, phoneNumber);
        this.businessName = businessName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

}
