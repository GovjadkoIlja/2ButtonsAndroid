package com.example.ilya.ourfuture.Markers;

import android.content.Intent;
import android.os.Bundle;

import com.example.ilya.ourfuture.Question.QuestionsListFragment;
import com.example.ilya.ourfuture.Question.Question;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Tops.TopQuestionsPresenter;
import com.example.ilya.ourfuture.UserPage.UsersQuestionsPresenter;

import java.util.ArrayList;


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

        ((MarkersQuestionsPresenter) questionsListPresenter).setType(type);
        //questionsListPresenter.receiveQuestions();
    }
}
