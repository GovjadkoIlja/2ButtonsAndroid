package com.example.ilya.ourfuture.QuestionPage;

/**
 * Created by Ilya on 13.02.2018.
 */

public interface IQuestionMainModel {
    void getResults(int minAge, int maxAge, int sex);
    void saveAnswer(int answer);
    boolean isAnswered();
    int getId();
}
