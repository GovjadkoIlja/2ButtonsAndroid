package com.example.ilya.ourfuture.News;

import com.example.ilya.ourfuture.Shared.ServerConnection;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ilya on 03.07.2018.
 */

public interface INewsRequest {
    @POST(ServerConnection.version + "/questions/news")
    Observable<NewsResponse> getNews(@Body NewsRequest newsRequest);
}
