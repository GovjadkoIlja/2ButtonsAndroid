package com.example.ilya.ourfuture.Question;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.ListFragment;

import com.example.ilya.ourfuture.Shared.ErrorFragment;
import com.example.ilya.ourfuture.R;

import java.util.ArrayList;

public abstract class QuestionsListFragment extends ListFragment {

    public QuestionsListPresenter questionsListPresenter;
    QuestionsAdapter adapter;

    ArrayList<Question> questions = new ArrayList<>();

    public void representQuestions(ArrayList<Question> questions) {
        this.questions = questions;

        adapter = new QuestionsAdapter(getActivity(), R.layout.fragment_closedquestion,
                R.layout.fragment_closedquestion, questions, this);
        setListAdapter(adapter);
    }

    public void errorOccured(int errorType) {
        Bundle errorArgs = new Bundle();

        errorArgs.putInt("errorType", errorType);

        Fragment errorFragment = new ErrorFragment();
        errorFragment.setArguments(errorArgs);
        FragmentTransaction markersOwnHeaderFt = getFragmentManager().beginTransaction();
        markersOwnHeaderFt.replace(this.getId(), errorFragment);
        markersOwnHeaderFt.commit();
    }

    public void getNewQuestionsSet() {
        questionsListPresenter.receiveQuestions();
    }

    public void addNewQuestions(ArrayList<Question> questions) {
        this.questions = questions;
        adapter.notifyDataSetChanged();
    }
}
