package com.example.ilya.ourfuture.QuestionPage;

import com.example.ilya.ourfuture.Shared.Question;

/**
 * Created by Ilya on 10.02.2018.
 */

public interface IQuestionHeaderModel {
    Question getNextQuestion();
    void feedbackChanged(int newFeedback);
    void favoritesChanged();
}
