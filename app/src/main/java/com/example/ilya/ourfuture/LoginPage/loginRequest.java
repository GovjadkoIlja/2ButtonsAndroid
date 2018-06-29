package com.example.ilya.ourfuture.LoginPage;

import com.example.ilya.ourfuture.Shared.LoginInfo;
import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Ilya on 07.01.2018.
 */

public interface loginRequest {
    /*@GET("/login")
    Observable<Object> login(@Query("login") String login, @Query("password") int password);*/

    //@FormUrlEncoded
    @POST(ServerConnection.version + "/auth/login")
    Observable<LoginResponse> login(@Body Credential credential /*@Field("login") String login, @Field("password") String password*/);
}
