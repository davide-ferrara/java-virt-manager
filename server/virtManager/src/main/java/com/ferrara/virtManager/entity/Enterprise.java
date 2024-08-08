package com.ferrara.virtManager.entity;

public class Enterprise extends Organization {
    private int companyID;
    private int credits = 25;

    public Enterprise(String companyName, String companyAddress, int companyID) {
        super(companyName, companyAddress);
        this.companyID = companyID;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

}
