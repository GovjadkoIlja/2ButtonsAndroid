package com.example.ilya.ourfuture.QuestionPage;

import com.example.ilya.ourfuture.Shared.Question;

import java.util.ArrayList;

/**
 * Created by Ilya on 10.02.2018.
 */

public interface IQuestionHeaderPresenter {
    void getQuestion();
    void feedbackChanged(boolean likeButton);
    void favoritesChanged();
}
