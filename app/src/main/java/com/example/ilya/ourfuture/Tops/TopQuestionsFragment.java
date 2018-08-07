package com.example.ilya.ourfuture.Tops;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ilya.ourfuture.Markers.MarkersQuestionsPresenter;
import com.example.ilya.ourfuture.Question.QuestionsListFragment;
import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.Id;

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

        ((TopQuestionsPresenter) questionsListPresenter).setType(type);
        //questionsListPresenter.receiveQuestions();
    }
}
