package com.example.ilya.ourfuture.Followers;

import com.example.ilya.ourfuture.Question.QuestionsListResponse;
import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.example.ilya.ourfuture.UsersList.UsersListResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ilya on 16.01.2018.
 */

public interface IFollowersRequest {
    @POST(ServerConnection.version + "/social/followers")
    Observable<UsersListResponse> getFollowers(@Body FollowersRequest followersRequest);

    @POST(ServerConnection.version + "/social/followings")
    Observable<UsersListResponse> getFollowTo(@Body FollowersRequest followersRequest);
}
