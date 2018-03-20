package com.example.ilya.ourfuture.QuestionPage;

/**
 * Created by Ilya on 10.02.2018.
 */

public interface IQuestionHeaderPresenter {
    void getQuestion();
    void feedbackChanged(boolean likeButton);
    void favoritesChanged();
}
