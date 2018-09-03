package com.TwoButtons.ilya.TwoButtons.Question;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.ListFragment;

import com.TwoButtons.ilya.TwoButtons.Shared.ErrorFragment;
import com.android.ilya.TwoButtons.R;

import java.util.ArrayList;

public abstract class QuestionsListFragment extends ListFragment {

    boolean isOpen;

    public QuestionsListPresenter questionsListPresenter;
    QuestionsAdapter adapter;

    ArrayList<Question> questions = new ArrayList<>();

    @Override
    public void onStart() {
        super.onStart();

        isOpen = true;
    }

    @Override
    public void onStop() {
        super.onStop();

        isOpen = false;
    }

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

    public void deleteQuestions() {
        if (adapter != null) {
            this.adapter.clear();
            this.adapter.notifyDataSetChanged();
            adapter = null;
        }
    }
}
