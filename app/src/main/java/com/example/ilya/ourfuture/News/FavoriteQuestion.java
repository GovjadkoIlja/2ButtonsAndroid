package com.example.ilya.ourfuture.News;

/**
 * Created by Ilya on 01.07.2018.
 */

public class FavoriteQuestion extends NewsQuestion {
    NewsUserInfo favoriteAddedUser;

    public FavoriteQuestion(String condition, String firstOption, String secondOption, String backgroundImageLink, int questionType) {
        super(condition, firstOption, secondOption, backgroundImageLink, questionType);
    }

    /*public FavoriteQuestion(String condition, String firstOption, String secondOption, String backgroundImageLink, int questionType,
                            int favoriteAddedUserId, String favoriteAddedUserLogin) {
        super(condition, firstOption, secondOption, backgroundImageLink, questionType);
        this.favoriteAddedUserId = favoriteAddedUserId;
        this.favoriteAddedUserLogin = favoriteAddedUserLogin;
    }*/

    @Override
    public String getDescription() {
        String description;

        if (favoriteAddedUser.sexType == 1)
            description = favoriteAddedUser.login + " добавил в избранное";
        else
            description = favoriteAddedUser.login + " добавила в избранное";

        return description;
    }
}
