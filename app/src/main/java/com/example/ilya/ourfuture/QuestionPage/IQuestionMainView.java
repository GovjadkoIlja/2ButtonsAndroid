package com.example.ilya.ourfuture.QuestionPage;

/**
 * Created by Ilya on 13.02.2018.
 */

public interface IQuestionMainView {
    void representAnswers(int firstAnswer, int secondAnswer);
    void representPercents(int firstPercent, int secondPercent);
    void representYourAnswer(int yourAnswer);
    void getPeopleList(int id, int questionId, int option, String firstOption, String secondOption);
}
