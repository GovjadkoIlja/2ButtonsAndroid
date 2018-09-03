package com.TwoButtons.ilya.TwoButtons.Followers;

import com.TwoButtons.ilya.TwoButtons.Shared.ServerConnection;
import com.TwoButtons.ilya.TwoButtons.UsersList.UsersListResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ilya on 28.08.2018.
 */

public interface IRecommendedRequest {
    @POST(ServerConnection.version + "/social/friends/recommended")
    Observable<RecommendedResponse> getRecommended(@Body RecommendedRequest recommendedRequest);
}
