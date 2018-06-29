package com.example.ilya.ourfuture.Tops;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ilya.ourfuture.Markers.MarkersQuestionsPresenter;
import com.example.ilya.ourfuture.Question.QuestionsListFragment;
import com.example.ilya.ourfuture.QuestionPage.QuestionActivity;
import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.Id;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopQuestionsFragment extends QuestionsListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        questionsListPresenter = new TopQuestionsPresenter(this);

        ((TopQuestionsPresenter)questionsListPresenter).receiveQuestions(1);
    }

    public void questionsTypeChanged(int type) { //as well will be executed authomatically from the header
        ((TopQuestionsPresenter)questionsListPresenter).receiveQuestions(type);
    }

}
