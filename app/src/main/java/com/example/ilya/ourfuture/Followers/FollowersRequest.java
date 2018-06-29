package com.example.ilya.ourfuture.Followers;

/**
 * Created by Ilya on 08.06.2018.
 */

public class FollowersRequest {
    int userId;
    int userPageId;
    String searchLogin;

    public FollowersRequest(int userId, int userPageId, String searchLogin) {
        this.userId = userId;
        this.userPageId = userPageId;
        this.searchLogin = searchLogin;
    }
}
