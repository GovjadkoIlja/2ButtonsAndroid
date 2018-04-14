package com.example.ilya.ourfuture.UserPage;

import com.google.gson.JsonElement;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ilya on 14.01.2018.
 */

public interface IPostsRequest {
    @GET("/getUserAskedQuestions")
    Observable<JsonElement> getPosts(@Query("id") int id, @Query("userId") int userId);
}
