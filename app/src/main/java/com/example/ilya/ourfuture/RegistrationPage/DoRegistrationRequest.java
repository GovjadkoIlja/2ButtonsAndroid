package com.example.ilya.ourfuture.RegistrationPage;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ilya on 10.01.2018.
 */

public interface DoRegistrationRequest {
    @GET("/addUser")
    Observable<Object> addUser(@Query("login") String login, @Query("password") int password, @Query("phone") String phone, @Query("description") String description, @Query("age") int age, @Query("sex") int sex);
}
