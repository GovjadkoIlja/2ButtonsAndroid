package com.example.ilya.ourfuture.Markers;

import android.content.Intent;
import android.os.Bundle;
import android.app.ListFragment;

import com.example.ilya.ourfuture.QuestionPage.Question;
import com.example.ilya.ourfuture.QuestionPage.QuestionActivity;
import com.example.ilya.ourfuture.R;

import java.util.ArrayList;


public class QuestionsFragment extends ListFragment implements IQuestionsView {

    IQuestionsPresenter questionsPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        questionsPresenter = new QuestionsPresenter(this);
    }

    @Override
    public void openQuestion(int id) {
        Intent intent = new Intent(this.getActivity(), QuestionActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    @Override
    public void representQuestions(ArrayList<Question> questions) {
        QuestionsAdapter adapter = new QuestionsAdapter(getActivity(), R.layout.fragment_post, R.layout.fragment_post, questions, questionsPresenter);
        setListAdapter(adapter);
    }

    public void questionsTypeChanged(int type) { //as well will be executed authomatically from the header
        questionsPresenter.questionsTypeChanged(type);
    }
}
