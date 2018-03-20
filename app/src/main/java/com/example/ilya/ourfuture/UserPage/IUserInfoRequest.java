package com.example.ilya.ourfuture.UserPage;

import com.google.gson.JsonElement;

import org.json.JSONObject;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ilya on 11.01.2018.
 */

public interface IUserInfoRequest {
    @GET("/getUserInfo")
    Observable<JsonElement> getUserInfo(@Query("id") int id, @Query("userId") int userId);
}
