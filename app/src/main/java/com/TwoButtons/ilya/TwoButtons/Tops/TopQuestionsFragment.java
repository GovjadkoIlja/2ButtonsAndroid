package com.TwoButtons.ilya.TwoButtons.Tops;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.TwoButtons.ilya.TwoButtons.Question.QuestionsListFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopQuestionsFragment extends QuestionsListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("BBBBBBBBBBBB");

        if (questionsListPresenter == null) { // If we goes not from error
            questionsListPresenter = new TopQuestionsPresenter(this);

            ((TopQuestionsPresenter) questionsListPresenter).setType(1);
            //questionsListPresenter.receiveQuestions();


        }
    }

    public void questionsTypeChanged(int type, boolean isFromErrorFragment) { //as well will be executed authomatically from the header
        if (isFromErrorFragment)
            questionsListPresenter = new TopQuestionsPresenter(this);

        deleteQuestions();

        questionsListPresenter.setType(type);
        //questionsListPresenter.receiveQuestions();
    }
}
