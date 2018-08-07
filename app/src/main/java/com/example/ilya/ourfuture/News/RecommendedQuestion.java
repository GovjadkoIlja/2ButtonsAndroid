package com.example.ilya.ourfuture.News;

import java.util.ArrayList;

/**
 * Created by Ilya on 03.07.2018.
 */

public class RecommendedQuestion extends NewsQuestion {
    ArrayList<NewsUserInfo> recommendedUsers;

    public RecommendedQuestion(String condition, String firstOption, String secondOption, String backgroundImageLink, int questionType) {
        super(condition, firstOption, secondOption, backgroundImageLink, questionType);
    }

   /* public RecommendedQuestion(String condition, String firstOption, String secondOption, String backgroundImageLink, int questionType,
                               int recommendedUserId, String recommendedUserLogin) {
        super(condition, firstOption, secondOption, backgroundImageLink, questionType);
        this.recommendedUserId = recommendedUserId;
        this.recommendedUserLogin = recommendedUserLogin;
    }*/

    @Override
    public String getDescription() {

        String description;

        String names = getUsersNames(recommendedUsers);

        if (recommendedUsers.size() > 1)
            description = " порекомендовали опрос";
        else
            description = recommendedUsers.get(0).sexType == 1 ? "порекомендовал опрос" : "порекомендовала опрос";

        return names + " " + description;
    }

    public String getUsersNames(ArrayList<NewsUserInfo> newsUsers) {
        String result;

        if (newsUsers.size() > 1)
            result = newsUsers.get(0).login + " и еще " + (newsUsers.size() - 1) + " пользователя";
        else
            result = newsUsers.get(0).login;

        return result;
    }
}
