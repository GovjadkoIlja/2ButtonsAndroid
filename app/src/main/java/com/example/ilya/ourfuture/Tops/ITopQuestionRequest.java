package com.example.ilya.ourfuture.Tops;

import com.example.ilya.ourfuture.Markers.MarkersRequest;
import com.example.ilya.ourfuture.Question.QuestionsListResponse;
import com.example.ilya.ourfuture.Shared.ServerConnection;

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
