package com.example.ilya.ourfuture.Markers;

import com.example.ilya.ourfuture.Question.QuestionsList;
import com.example.ilya.ourfuture.Question.QuestionsListResponse;
import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.google.gson.JsonElement;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Ilya on 07.03.2018.
 */

public interface IGetPersonalQuestionsRequest {
    @POST(ServerConnection.version + "/questions/personal/asked")
    Observable<QuestionsListResponse> getAsked(@Body MarkersRequest markersRequest);

    @POST(ServerConnection.version + "/questions/personal/liked")
    Observable<QuestionsListResponse> getLiked(@Body MarkersRequest markersRequest);

    @POST(ServerConnection.version + "/questions/personal/saved")
    Observable<QuestionsListResponse> getSaved(@Body MarkersRequest markersRequest);

    @GET("/getFavorites")
    Observable<JsonElement> getFavorites(@Query("id") int id);

    @GET("/getSaved")
    Observable<JsonElement> getHistory(@Query("id") int id);
}
