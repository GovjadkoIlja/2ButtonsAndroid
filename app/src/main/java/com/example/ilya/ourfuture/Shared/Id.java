package com.example.ilya.ourfuture.Shared;

import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Ilya on 01.03.2018.
 */

public class Id {
    public static int id;
    public static String smallAvatarLink;
    public static String login;
    public static String accessToken;
    public static String refreshToken;
    public static int roleType;

    public Id(int userId, String smallAvatarLink, String login, String accessToken, String refreshToken, int roleType) {
        id = userId;
        Id.smallAvatarLink = smallAvatarLink;
        Id.login = login;
        Id.accessToken = accessToken;
        Id.refreshToken = refreshToken;
        Id.roleType = roleType;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int _id) {
        id = _id;
    }
    public static void setSmallAvatarLink(String _smallAvatarLink) {
        smallAvatarLink = _smallAvatarLink;
    }

    public static void setLogin(String _login) {
        login = _login;
    }

    public static String getLogin(){
        return login;
    }

    public static String getSmallAvatarLink() {
        return smallAvatarLink;
    }
}
