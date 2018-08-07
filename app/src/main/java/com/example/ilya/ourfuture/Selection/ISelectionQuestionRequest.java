package com.example.ilya.ourfuture.Selection;

import com.example.ilya.ourfuture.Markers.MarkersRequest;
import com.example.ilya.ourfuture.Question.QuestionsListResponse;
import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.example.ilya.ourfuture.Tops.TopRequest;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ilya on 05.06.2018.
 */

public interface ISelectionQuestionRequest {
    @POST(ServerConnection.version + "/questions/personal/selected")
    Observable<QuestionsListResponse> getSelection(@Body MarkersRequest markersRequest);
}
