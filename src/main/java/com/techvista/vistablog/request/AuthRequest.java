package com.techvista.vistablog.request;

public class AuthRequest {

    final String username;
    final String password;

    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
