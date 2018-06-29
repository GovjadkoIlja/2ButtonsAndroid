package com.example.ilya.ourfuture.Tops;

import com.example.ilya.ourfuture.Question.Question;
import com.example.ilya.ourfuture.Question.QuestionsList;
import com.example.ilya.ourfuture.Question.QuestionsListFragment;
import com.example.ilya.ourfuture.Question.QuestionsListPresenter;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.UserPage.UsersQuestionsModel;

import java.util.ArrayList;

/**
 * Created by Ilya on 04.06.2018.
 */

public class TopQuestionsPresenter extends QuestionsListPresenter {

    final int daySeconds = 86400;

    TopQuestionsPresenter(QuestionsListFragment questionsView) {
        questionsListFragment = questionsView;
        questionsListModel = new TopQuestionsModel(this);
    }

    public void receiveQuestions(int type) {
        System.out.println(type);

        int deltaUnixTime = 0;

        switch (type) {
            case 1:
                deltaUnixTime = daySeconds;
                break;
            case 2:
                deltaUnixTime = daySeconds * 7;
                break;
            case 3:
                deltaUnixTime = daySeconds * 30;
                break;
            case 4:
                deltaUnixTime = 0;
                break;
        }

        ((TopQuestionsModel)questionsListModel).receiveTopQuestions(deltaUnixTime, false, 1);
    }
}
