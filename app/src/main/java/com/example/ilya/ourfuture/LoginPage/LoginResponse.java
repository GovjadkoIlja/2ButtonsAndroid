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
    Token token;
    LoginUserInfo user;
}

class Token {
    int userId;
    int roleType;
    String accessToken;
    String refreshToken;
    int expiresIn;
}

class LoginUserInfo {
    int userId;
    String login;
    String birthDate;
    int sex;
    String city;
    String description;
    String largeAvatarUrl;
    String smallAvatarUrl;
}
