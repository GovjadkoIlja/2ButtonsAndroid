package com.TwoButtons.ilya.TwoButtons.News;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.TwoButtons.ilya.TwoButtons.Shared.ErrorFragment;
import com.android.ilya.TwoButtons.R;

import java.util.ArrayList;

public class NewsQuestionsFragment extends ListFragment {

    NewsQuestionsPresenter newsQuestionsPresenter;

    ArrayList<NewsQuestion> newsQuestions;
    NewsQuestionsAdapter adapter;

    boolean isOpen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        newsQuestionsPresenter = new NewsQuestionsPresenter(this);

        newsQuestionsPresenter.receiveQuestions();

        View view = inflater.inflate(R.layout.fragment_newsquestion_list, container, false);

        return view;
    }

    public void representQuestions(ArrayList<NewsQuestion> questions) {
        newsQuestions = questions;

        adapter = new NewsQuestionsAdapter(getActivity(), R.layout.fragment_closedquestion,
                R.layout.fragment_closedquestion, questions, this);
        setListAdapter(adapter);
    }

    public void errorOccured(int errorType) {
        Bundle errorArgs = new Bundle();

        errorArgs.putInt("errorType", errorType);

        Fragment errorFragment = new ErrorFragment();
        errorFragment.setArguments(errorArgs);
        FragmentTransaction markersOwnHeaderFt = getFragmentManager().beginTransaction();
        markersOwnHeaderFt.add(this.getId(), errorFragment);
        markersOwnHeaderFt.commit();
    }

    public void getNewQuestionsSet() {
        newsQuestionsPresenter.receiveQuestions();
    }

    public void addNewQuestions(ArrayList<NewsQuestion> questions) {
        this.newsQuestions = questions;
        adapter.notifyDataSetChanged();
    }
}
