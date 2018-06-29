package com.example.ilya.ourfuture.LoginPage;

/**
 * Created by Ilya on 18.05.2018.
 */

class LoginResponse {
    int status;
    String message;
    LoginData data;
}

class LoginData {
    int userId;
    int roleType;
    String accessToken;
    String refreshToken;
    int expiresIn;
}
