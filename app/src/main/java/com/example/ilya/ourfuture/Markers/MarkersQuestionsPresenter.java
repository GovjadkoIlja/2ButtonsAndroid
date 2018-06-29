package com.example.ilya.ourfuture.Markers;

import com.example.ilya.ourfuture.Question.QuestionsList;
import com.example.ilya.ourfuture.Question.QuestionsListFragment;
import com.example.ilya.ourfuture.Question.QuestionsListPresenter;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Question.Question;
import com.example.ilya.ourfuture.UserPage.UsersQuestionsModel;

import java.util.ArrayList;

/**
 * Created by Ilya on 07.03.2018.
 */

public class MarkersQuestionsPresenter extends QuestionsListPresenter {

    MarkersQuestionsPresenter(QuestionsListFragment _markersView) {
        questionsListFragment = _markersView;
        questionsListModel = new MarkersQuestionsModel(this);
    }

    public void receiveQuestions(int type) {
        System.out.println(type);
        switch (type) {
            case 1:
                ((MarkersQuestionsModel) questionsListModel).receiveUserAskedQuestions(1);
                break;
            case 2:
                ((MarkersQuestionsModel) questionsListModel).receiveUserLikedQuestions(1);
                break;
            case 3:
                ((MarkersQuestionsModel) questionsListModel).receiveUserSavedQuestions(1);
                break;
        }
    }

}
