package com.example.ilya.ourfuture.PeopleList;

import com.google.gson.JsonElement;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ilya on 16.02.2018.
 */

public interface IQuestionPeopleListRequest {
    @GET("/getVoters")
    Observable<JsonElement> getVoters(@Query("id") int id, @Query("questionId") int questionId, @Query("option") int option, @Query("minAge") int minAge, @Query("maxAge") int maxAge, @Query("sex") int sex, @Query("search") String search);
}
