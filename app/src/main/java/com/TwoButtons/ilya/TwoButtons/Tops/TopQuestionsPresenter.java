package com.TwoButtons.ilya.TwoButtons.Tops;

import com.TwoButtons.ilya.TwoButtons.Question.QuestionsListFragment;
import com.TwoButtons.ilya.TwoButtons.Question.QuestionsListPresenter;

/**
 * Created by Ilya on 04.06.2018.
 */

public class TopQuestionsPresenter extends QuestionsListPresenter {

    private final int daySeconds = 86400;

    TopQuestionsPresenter(QuestionsListFragment questionsView) {
        questionsListFragment = questionsView;
        questionsListModel = new TopQuestionsModel(this);
    }

    @Override
    public void receiveQuestions() {
        System.out.println(type);

        if (questionsListModel.getIsInProcess())
            return;

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

        ((TopQuestionsModel)questionsListModel).receiveTopQuestions(type, deltaUnixTime, false, 1);
    }
}
