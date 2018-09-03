package com.TwoButtons.ilya.TwoButtons.Voters;

import com.TwoButtons.ilya.TwoButtons.Shared.ServerConnection;
import com.TwoButtons.ilya.TwoButtons.UsersList.UsersListResponse;

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
