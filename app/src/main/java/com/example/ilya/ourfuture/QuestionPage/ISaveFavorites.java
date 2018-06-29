package com.example.ilya.ourfuture.QuestionPage;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ilya on 13.02.2018.
 */

public interface ISaveFavorites {
    @GET("/saveFavorites")
    Observable<Integer> saveFavorites(@Query("id") int id, @Query("questionId") int questionId, @Query("isInFavorites") boolean inFavorites);
}
