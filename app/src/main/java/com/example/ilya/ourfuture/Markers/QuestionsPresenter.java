package com.example.ilya.ourfuture.Markers;

import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.Question;

import java.util.ArrayList;

/**
 * Created by Ilya on 07.03.2018.
 */

public class QuestionsPresenter implements IQuestionsPresenter {

    IQuestionsView questionsView;
    IQuestionsModel questionsModel;

    public QuestionsPresenter(IQuestionsView _questionsView) {
        questionsView = _questionsView;
        questionsModel = new QuestionsModel(this);
    }

    @Override
    public void questionClicked(int position, ArrayList<Question> questions) {
        questionsView.openQuestion(Id.getId());
    }

    @Override
    public void questionsGot(ArrayList<Question> questions) {
        questionsView.representQuestions(questions);
    }

    @Override
    public void questionsTypeChanged(int type) {
        questionsModel.receiveQuestions(type);
    }

}
