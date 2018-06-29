package com.example.ilya.ourfuture.LoginPage;

/**
 * Created by Ilya on 23.04.2018.
 */

public class Credential {
    String phone;
    String password;
    int grantType;

    public Credential(String phone, String password, int grantType) {
        this.phone = phone;
        this.password = password;
        this.grantType = grantType;
    }
}
