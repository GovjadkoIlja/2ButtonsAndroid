package com.TwoButtons.ilya.TwoButtons.Tops;

import com.TwoButtons.ilya.TwoButtons.Shared.ServerConnection;
import com.TwoButtons.ilya.TwoButtons.Question.QuestionsListResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ilya on 04.06.2018.
 */

public interface ITopQuestionRequest {
    @POST(ServerConnection.version + "/questions/personal/top")
    Observable<QuestionsListResponse> getTop(@Body TopRequest topRequest);
}
