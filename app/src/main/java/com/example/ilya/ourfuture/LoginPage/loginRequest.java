package com.example.ilya.ourfuture.LoginPage;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ilya on 07.01.2018.
 */

public interface loginRequest {
    @GET("/login")
    Observable<Object> login(@Query("login") String login, @Query("password") int password);
}
