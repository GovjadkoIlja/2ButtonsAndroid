package com.example.ilya.ourfuture.UserPage;

import com.example.ilya.ourfuture.Question.QuestionsListResponse;
import com.example.ilya.ourfuture.Shared.ServerConnection;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ilya on 24.04.2018.
 */

public interface IUsersQuestionsRequest {
   /* @POST("/getUserAskedQuestions")
    Observable<JsonElement> getUserAskedQuestions(@Body UserInfoRequest userQuestionsRequest);
*/
    @POST(ServerConnection.version + "/questions/user/asked")
    Observable<QuestionsListResponse> getUserAskedQuestions(@Body UserQuestionsRequest userQuestionsRequest);

    @POST(ServerConnection.version + "/questions/user/answered")
    Observable<QuestionsListResponse> getUserAnsweredQuestions(@Body UserQuestionsRequest userQuestionsRequest);

    @POST(ServerConnection.version + "/questions/user/favorite")
    Observable<QuestionsListResponse> getUserFavoriteQuestions(@Body UserQuestionsRequest userQuestionsRequest);
}
