package com.example.ilya.ourfuture.CreateQuestion;

import com.example.ilya.ourfuture.Markers.MarkersRequest;
import com.example.ilya.ourfuture.Shared.ServerConnection;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ilya on 16.07.2018.
 */

public interface IBackgroundsRequest {
    @POST(ServerConnection.version + "/media/standards/background")
    Observable<BackgroundsResponse> getStandardBackgrounds(@Body BackgroundsRequest backgroundsRequest);
}
