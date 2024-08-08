package com.ferrara.virtManager.classes;

public class LoginResponse {
    private long token;

    public LoginResponse(long token) {
        this.token = token;
    }

    public long getToken() {
        return token;
    }

    public void setToken(long token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginResponse[id=" + token + "]";
    }

}
