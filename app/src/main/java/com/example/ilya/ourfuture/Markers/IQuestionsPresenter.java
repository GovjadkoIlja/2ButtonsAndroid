package com.example.ilya.ourfuture.Markers;

import com.example.ilya.ourfuture.QuestionPage.Question;

import java.util.ArrayList;

/**
 * Created by Ilya on 07.03.2018.
 */

public interface IQuestionsPresenter {
    void questionClicked(int position, ArrayList<Question> questions);
    void questionsGot(ArrayList<Question> questions);
    void questionsTypeChanged(int type);
}
