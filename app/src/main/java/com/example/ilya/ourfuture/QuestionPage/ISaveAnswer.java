package com.example.ilya.ourfuture.QuestionPage;

import com.google.gson.JsonElement;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ilya on 13.02.2018.
 */

public interface ISaveAnswer {
    @GET("/saveAnswer")
    Observable<JsonElement> saveAnswer(@Query("id") int id, @Query("questionId") int questionId, @Query("answer") int answer);
}
