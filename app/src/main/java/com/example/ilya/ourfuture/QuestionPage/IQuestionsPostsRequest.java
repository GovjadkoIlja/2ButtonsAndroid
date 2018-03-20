package com.example.ilya.ourfuture.QuestionPage;

import com.google.gson.JsonElement;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ilya on 09.02.2018.
 */

public interface IQuestionsPostsRequest {
    @GET("/getNewQuestionsPosts")
    Observable<JsonElement> getPosts(@Query("id") int id, @Query("userId") int userId);
}
