package com.TwoButtons.ilya.TwoButtons.Question;

/**
 * Created by Ilya on 03.06.2018.
 */

public class AddFavoritesRequest {
    int userId;
    int questionId;
    boolean isInFavorites;

    public AddFavoritesRequest(int userId, int questionId, boolean isInFavorites) {
        this.userId = userId;
        this.questionId = questionId;
        this.isInFavorites = isInFavorites;
    }
}
