package com.example.ilya.ourfuture.CreateQuestion;

import com.example.ilya.ourfuture.Shared.ServerConnection;

import org.json.JSONObject;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ilya on 24.06.2018.
 */

public interface ICreateQuestionRequest {
    @POST(ServerConnection.version + "/questions/add")
    Observable<JSONObject> createQuestion(@Body CreateQuestionRequest createQuestionRequest);
}
