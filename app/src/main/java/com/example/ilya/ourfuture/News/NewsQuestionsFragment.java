package com.example.ilya.ourfuture.News;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ilya.ourfuture.Question.Question;
import com.example.ilya.ourfuture.Shared.ErrorFragment;
import com.example.ilya.ourfuture.R;

import java.util.ArrayList;

public class NewsQuestionsFragment extends ListFragment {

    NewsQuestionsPresenter newsQuestionsPresenter;

    ArrayList<NewsQuestion> newsQuestions;
    NewsQuestionsAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
