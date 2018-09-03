package com.TwoButtons.ilya.TwoButtons.Markers;

import com.TwoButtons.ilya.TwoButtons.Question.Question;

import java.util.ArrayList;

/**
 * Created by Ilya on 07.03.2018.
 */

public interface IQuestionsPresenter {
    void questionClicked(int position, ArrayList<Question> questions);
    void questionsGot(ArrayList<Question> questions);
    void questionsTypeChanged(int type);
}
