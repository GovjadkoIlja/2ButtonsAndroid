package com.TwoButtons.ilya.TwoButtons.Markers;

import android.os.Bundle;

import com.TwoButtons.ilya.TwoButtons.Question.QuestionsListFragment;


public class MarkersQuestionsFragment extends QuestionsListFragment implements IQuestionsView {

    //IQuestionsPresenter questionsPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        questionsListPresenter = new MarkersQuestionsPresenter(this);

        ((MarkersQuestionsPresenter)questionsListPresenter).setType(1);
    }

    public void questionsTypeChanged(int type, boolean isFromErrorFragment) { //as well will be executed authomatically from the header
        if (isFromErrorFragment)
            questionsListPresenter = new MarkersQuestionsPresenter(this);
        else
            deleteQuestions();

        ((MarkersQuestionsPresenter) questionsListPresenter).setType(type);
        //questionsListPresenter.receiveQuestions();
    }
}
