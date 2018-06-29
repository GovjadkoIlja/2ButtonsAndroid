package com.example.ilya.ourfuture.Question;

import android.content.Intent;
import android.os.Bundle;
import android.app.ListFragment;

import com.example.ilya.ourfuture.QuestionPage.QuestionActivity;
import com.example.ilya.ourfuture.R;

import java.util.ArrayList;

public abstract class QuestionsListFragment extends ListFragment {

    public QuestionsListPresenter questionsListPresenter;

    public void representQuestions(ArrayList<Question> questions) {
        QuestionsAdapter adapter = new QuestionsAdapter(getActivity(), R.layout.fragment_closedquestion, R.layout.fragment_closedquestion, questions);
        setListAdapter(adapter);
    }

    public void openQuestion(int id, int position, ArrayList<Question> questions) {
        Intent intent = new Intent(this.getActivity(), QuestionActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("position", position);
        intent.putExtra("questions", questions);
        startActivity(intent);
    }

}
