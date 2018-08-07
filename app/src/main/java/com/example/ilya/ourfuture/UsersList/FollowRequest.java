package com.example.ilya.ourfuture.UsersList;

/**
 * Created by Ilya on 10.06.2018.
 */

public class FollowRequest {
    int userId;
    int followingId;

    public FollowRequest(int userId, int followingId) {
        this.userId = userId;
        this.followingId = followingId;
    }
}
