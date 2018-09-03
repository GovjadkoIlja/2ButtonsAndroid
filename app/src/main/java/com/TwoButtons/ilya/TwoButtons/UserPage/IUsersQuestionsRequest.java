package com.TwoButtons.ilya.TwoButtons.UserPage;

import com.TwoButtons.ilya.TwoButtons.Question.QuestionsListResponse;
import com.TwoButtons.ilya.TwoButtons.Shared.ServerConnection;

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
