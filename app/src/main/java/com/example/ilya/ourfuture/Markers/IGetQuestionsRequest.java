package com.example.ilya.ourfuture.Markers;

import com.google.gson.JsonElement;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ilya on 07.03.2018.
 */

public interface IGetQuestionsRequest {
    @GET("/getMy")
    Observable<JsonElement> getMy(@Query("id") int id);

    @GET("/getFavorites")
    Observable<JsonElement> getFavorites(@Query("id") int id);

    @GET("/getHistory")
    Observable<JsonElement> getHistory(@Query("id") int id);
}
