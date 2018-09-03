package com.TwoButtons.ilya.TwoButtons.UserPage;

import com.TwoButtons.ilya.TwoButtons.Shared.ServerConnection;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ilya on 11.01.2018.
 */

public interface IUserInfoRequest {
    /*@GET("/getUserInfo")
    Observable<JsonElement> getUserInfo(@Query("id") int id, @Query("userId") int userId);*/

    @POST(ServerConnection.version + "/account/get")
    Observable<UserInfoResponse> getUserInfo(@Body UserInfoRequest userInfoRequest);
}
