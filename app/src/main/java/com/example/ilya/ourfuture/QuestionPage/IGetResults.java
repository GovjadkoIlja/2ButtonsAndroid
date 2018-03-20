package com.example.ilya.ourfuture.QuestionPage;

import com.google.gson.JsonElement;

import org.json.JSONObject;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ilya on 13.02.2018.
 */

public interface IGetResults {
    @GET("/getResults")
    Observable<JsonElement> getResults(@Query("id") int id, @Query("questionId") int questionId, @Query("minAge") int minAge, @Query("maxAge") int maxAge, @Query("sex") int sex);
}
