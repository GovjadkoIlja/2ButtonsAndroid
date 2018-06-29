package com.example.ilya.ourfuture.UsersList;

/**
 * Created by Ilya on 10.06.2018.
 */

public class FollowRequest {
    int userId;
    int followToId;

    public FollowRequest(int userId, int followToId) {
        this.userId = userId;
        this.followToId = followToId;
    }
}
