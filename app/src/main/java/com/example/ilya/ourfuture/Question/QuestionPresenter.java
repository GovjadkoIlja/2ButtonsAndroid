package com.example.ilya.ourfuture.Question;

import java.util.ArrayList;

/**
 * Created by Ilya on 22.06.2018.
 */

public class QuestionPresenter {
    //public QuestionView questionView;
    public QuestionModel questionsListModel;

    //public abstract void questionClicked(int position, ArrayList<Question> questions);
    //public abstract void receiveQuestions(int userId);

    /*public void questionsGot(ArrayList<Question> questions) {
        questionsListFragment.representQuestions(questions);
    }*/

    public QuestionPresenter() {
        questionsListModel = new QuestionModel(this);
    }

    public void addAnswer(Question question, int answer) {
        questionsListModel.addAnswer(question, answer);
    }

    public void addFeedback(Question question, int feedback) {
        questionsListModel.addFeedback(question, feedback);
    }

    public void addFavorites(Question question, boolean isInFavorites) {
        questionsListModel.addFavorites(question, isInFavorites);
    }
}
