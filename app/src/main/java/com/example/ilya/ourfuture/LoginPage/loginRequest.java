package com.example.ilya.ourfuture.LoginPage;

import android.net.Credentials;

import com.google.gson.JsonElement;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Ilya on 07.01.2018.
 */

public interface loginRequest {
    /*@GET("/login")
    Observable<Object> login(@Query("login") String login, @Query("password") int password);*/

    //@FormUrlEncoded
    @POST("/login")
    Observable<Object> login(@Body Credential credential /*@Field("login") String login, @Field("password") String password*/);
}
