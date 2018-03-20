package com.example.ilya.ourfuture.PeopleList;

import com.google.gson.JsonElement;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ilya on 16.01.2018.
 */

public interface IPeopleListRequest {
    @GET("/getFollowers")
    Observable<JsonElement> getFollowers(@Query("id") int id, @Query("userId") int userId);

    @GET("/getFollowTo")
    Observable<JsonElement> getFollowTo(@Query("id") int id, @Query("userId") int userId);
}
