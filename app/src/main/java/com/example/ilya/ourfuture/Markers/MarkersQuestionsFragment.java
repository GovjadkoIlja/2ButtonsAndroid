package com.example.ilya.ourfuture.Markers;

import android.content.Intent;
import android.os.Bundle;

import com.example.ilya.ourfuture.Question.QuestionsListFragment;
import com.example.ilya.ourfuture.QuestionPage.QuestionActivity;
import com.example.ilya.ourfuture.Question.Question;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.UserPage.UsersQuestionsPresenter;

import java.util.ArrayList;


public class MarkersQuestionsFragment extends QuestionsListFragment implements IQuestionsView {

    //IQuestionsPresenter questionsPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        questionsListPresenter = new MarkersQuestionsPresenter(this);

        ((MarkersQuestionsPresenter)questionsListPresenter).receiveQuestions(Id.getId());
    }

    @Override
    public void openQuestion(int id) {
        Intent intent = new Intent(this.getActivity(), QuestionActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    public void questionsTypeChanged(int type) { //as well will be executed authomatically from the header
        ((MarkersQuestionsPresenter)questionsListPresenter).receiveQuestions(type);
    }
}
