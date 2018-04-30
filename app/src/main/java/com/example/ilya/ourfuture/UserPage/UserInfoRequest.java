package com.example.ilya.ourfuture.UserPage;

/**
 * Created by Ilya on 24.04.2018.
 */

public class UserInfoRequest {
    int userId;
    int userPageId;

    public UserInfoRequest(int userId, int userPageId) {
        this.userId = userId;
        this.userPageId = userPageId;
    }
}
