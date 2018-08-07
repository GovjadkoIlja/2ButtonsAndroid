package com.example.ilya.ourfuture.Selection;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ilya.ourfuture.Question.QuestionsListFragment;
import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Tops.TopQuestionsPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectionQuestionsFragment extends QuestionsListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("AAAAAAA");
        questionsListPresenter = new SelectionQuestionsPresenter(this);

        questionsListPresenter.receiveQuestions();
    }
}
