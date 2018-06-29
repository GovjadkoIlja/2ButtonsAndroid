package com.example.ilya.ourfuture.Shared;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Ilya on 18.05.2018.
 */

public class LoginInfo {
    static int userId;
    static int roleType;
    static String accessToken;

    public LoginInfo(int userId, int roleType, String accessToken) {
        LoginInfo.userId = userId;
        LoginInfo.roleType = roleType;
        LoginInfo.accessToken = accessToken;
    }

    public static int getUserId() {
        return userId;
    }

    public int getRoleType() {
        return roleType;
    }

    public String getAccessToken() {
        return accessToken;
    }


}
