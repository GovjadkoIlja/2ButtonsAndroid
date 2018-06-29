package com.example.ilya.ourfuture.Selection;

import com.example.ilya.ourfuture.Question.Question;
import com.example.ilya.ourfuture.Question.QuestionsList;
import com.example.ilya.ourfuture.Question.QuestionsListFragment;
import com.example.ilya.ourfuture.Question.QuestionsListPresenter;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Tops.TopQuestionsModel;

import java.util.ArrayList;

/**
 * Created by Ilya on 05.06.2018.
 */

public class SelectionQuestionsPresenter extends QuestionsListPresenter {
    SelectionQuestionsPresenter(QuestionsListFragment questionsView) {
        questionsListFragment = questionsView;
        questionsListModel = new SelectionQuestionsModel(this);
    }

    public void receiveQuestions(int type) {
        System.out.println(type);

        ((SelectionQuestionsModel)questionsListModel).receiveSelectionQuestions();
    }
}
