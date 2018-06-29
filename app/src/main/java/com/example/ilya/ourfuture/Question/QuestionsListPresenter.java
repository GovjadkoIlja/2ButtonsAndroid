package com.example.ilya.ourfuture.Question;

import java.util.ArrayList;

/**
 * Created by Ilya on 27.04.2018.
 */

public abstract class QuestionsListPresenter {

    public QuestionsListFragment questionsListFragment;
    public QuestionsListModel questionsListModel;

    public void questionsGot(ArrayList<Question> questions) {
        questionsListFragment.representQuestions(questions);
    }
}
