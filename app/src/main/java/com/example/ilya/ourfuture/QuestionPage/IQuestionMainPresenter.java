package com.example.ilya.ourfuture.QuestionPage;

/**
 * Created by Ilya on 13.02.2018.
 */

public interface IQuestionMainPresenter {
    //void getAnsweredInfo();
    //void representAnswered();
    void optionClicked(int option);
    //void answer(int answer);
    void representAnswered(int firstOption, int secondOption, int yourAnswer);
}
