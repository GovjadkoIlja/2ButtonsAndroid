package com.example.ilya.ourfuture.UserPage;

import com.google.gson.JsonElement;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ilya on 24.04.2018.
 */

public interface IUserQuestionsListRequest {
    @POST("/getUserAskedQuestions")
    Observable<JsonElement> getUserAskedQuestions(@Body UserInfoRequest userInfoRequest);

    @POST("/getUserAnsweredQuestions")
    Observable<JsonElement> getUserAnsweredQuestions(@Body UserInfoRequest userInfoRequest);
}
