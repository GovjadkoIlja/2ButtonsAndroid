package com.example.ilya.ourfuture.LoginPage;

import com.example.ilya.ourfuture.Shared.ServerConnection;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ilya on 25.07.2018.
 */

public interface IExternalLoginRequest {
    @POST(ServerConnection.version + "/auth/externalLogin/mobile")
    Observable<LoginResponse> vkLogin(@Body VkLoginRequest vkLoginRequest);
}
