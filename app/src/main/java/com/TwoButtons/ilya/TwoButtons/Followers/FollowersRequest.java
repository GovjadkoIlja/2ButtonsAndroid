package com.TwoButtons.ilya.TwoButtons.Followers;

/**
 * Created by Ilya on 08.06.2018.
 */

public class FollowersRequest {
    int userId;
    int userPageId;
    String searchedLogin;

    public FollowersRequest(int userId, int userPageId, String searchedLogin) {
        this.userId = userId;
        this.userPageId = userPageId;
        this.searchedLogin = searchedLogin;
    }
}
