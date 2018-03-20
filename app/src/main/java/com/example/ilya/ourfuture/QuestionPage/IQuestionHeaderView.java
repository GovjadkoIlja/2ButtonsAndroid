package com.example.ilya.ourfuture.QuestionPage;

/**
 * Created by Ilya on 10.02.2018.
 */

public interface IQuestionHeaderView {
    void fillLogin(String login);
    void fillQuestionType(String type);
    void setRaiting(String raiting);
    void setFeedback(boolean isLiked, boolean isDisliked);
    void setFavorites(boolean inFavorites);
}
