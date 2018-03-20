package com.example.ilya.ourfuture.QuestionPage;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ilya on 10.02.2018.
 */

public interface ISaveFeedback {
    @GET("/saveFeedback")
    Observable<Integer> saveFeedback(@Query("id") int id, @Query("questionId") int questionId, @Query("feedback") int feedback);
}
