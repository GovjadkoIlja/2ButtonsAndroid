package com.example.ilya.ourfuture.UserPage;

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

    @POST("/getUserInfo")
    Observable<JsonElement> getUserInfo(@Body UserInfoRequest userInfoRequest);
}
