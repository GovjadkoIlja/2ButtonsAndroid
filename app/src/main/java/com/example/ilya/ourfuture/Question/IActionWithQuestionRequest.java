package com.example.ilya.ourfuture.Question;

import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.google.gson.JsonElement;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ilya on 02.06.2018.
 */

public interface IActionWithQuestionRequest {
    @POST(ServerConnection.version + "/questions/update/answer")
    Observable<JsonElement> addAnswer(@Body AddAnswerRequest addAnswerRequest);

    @POST(ServerConnection.version + "/questions/update/feedback")
    Observable<JsonElement> addFeedback(@Body AddFeedbackRequest addFeedbackRequest);

    @POST(ServerConnection.version + "/questions/update/favorites")
    Observable<JsonElement> addFavorites(@Body AddFavoritesRequest addFavoritesRequest);
}
