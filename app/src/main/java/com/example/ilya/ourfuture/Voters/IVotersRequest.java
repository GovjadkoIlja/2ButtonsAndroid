package com.example.ilya.ourfuture.Voters;

import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.example.ilya.ourfuture.UsersList.UsersListResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ilya on 30.06.2018.
 */

public interface IVotersRequest {
    @POST(ServerConnection.version + "/questions/voters")
    Observable<UsersListResponse> getVoters(@Body VotersRequest votersRequest);
}
