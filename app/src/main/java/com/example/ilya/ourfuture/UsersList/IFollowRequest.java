package com.example.ilya.ourfuture.UsersList;

import com.example.ilya.ourfuture.Followers.FollowersRequest;
import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.google.gson.JsonElement;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ilya on 10.06.2018.
 */

public interface IFollowRequest {
    @POST(ServerConnection.version + "/social/followers/follow")
    Observable<JsonElement> follow(@Body FollowRequest followRequest);

    @POST(ServerConnection.version + "/social/followers/unfollow")
    Observable<JsonElement> unfollow(@Body FollowRequest followRequest);
}
