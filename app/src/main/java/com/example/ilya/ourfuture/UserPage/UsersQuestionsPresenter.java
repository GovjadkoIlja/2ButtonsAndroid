package com.example.ilya.ourfuture.UserPage;

import com.example.ilya.ourfuture.Markers.MarkersQuestionsModel;
import com.example.ilya.ourfuture.Question.Question;
import com.example.ilya.ourfuture.Question.QuestionsList;
import com.example.ilya.ourfuture.Question.QuestionsListFragment;
import com.example.ilya.ourfuture.Question.QuestionsListPresenter;
import com.example.ilya.ourfuture.Shared.Id;

import java.util.ArrayList;

public class UsersQuestionsPresenter extends QuestionsListPresenter  {

    UsersQuestionsPresenter(int userId, QuestionsListFragment _postsView) {
        questionsListFragment = _postsView;
        questionsListModel = new UsersQuestionsModel(userId, this);
    }

    public void receiveQuestions(int type) {
        System.out.println(type);
        switch (type) {
            case 1:
                ((UsersQuestionsModel) questionsListModel).receiveAskedQuestions();
                break;
            case 2:
                ((UsersQuestionsModel) questionsListModel).receiveAnsweredQuestions();
                break;
            case 3:
                ((UsersQuestionsModel) questionsListModel).receiveFavoriteQuestions();
                break;
        }
    }


}
