package com.TwoButtons.ilya.TwoButtons.Markers;

import com.TwoButtons.ilya.TwoButtons.Question.QuestionsListResponse;
import com.TwoButtons.ilya.TwoButtons.Shared.ServerConnection;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ilya on 07.03.2018.
 */

public interface IGetPersonalQuestionsRequest {
    @POST(ServerConnection.version + "/questions/personal/asked")
    Observable<QuestionsListResponse> getAsked(@Body MarkersRequest markersRequest);

    @POST(ServerConnection.version + "/questions/personal/liked")
    Observable<QuestionsListResponse> getLiked(@Body MarkersRequest markersRequest);

    @POST(ServerConnection.version + "/questions/personal/saved")
    Observable<QuestionsListResponse> getSaved(@Body MarkersRequest markersRequest);
}
