package com.example.ilya.ourfuture.UserPage;

import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.google.gson.JsonElement;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ilya on 11.01.2018.
 */

public interface IUserInfoRequest {
    /*@GET("/getUserInfo")
    Observable<JsonElement> getUserInfo(@Query("id") int id, @Query("userId") int userId);*/

    @POST(ServerConnection.version + "/account/get")
    Observable<UserInfoResponse> getUserInfo(@Body UserInfoRequest userInfoRequest);
}
