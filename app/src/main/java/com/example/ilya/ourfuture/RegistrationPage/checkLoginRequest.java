package com.example.ilya.ourfuture.RegistrationPage;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ilya on 09.01.2018.
 */

public interface checkLoginRequest {
    @GET("/checkValidLogin")
    Observable<Object> checkLogin(@Query("login") String login);
}
