package com.TwoButtons.ilya.TwoButtons.Markers;

import com.TwoButtons.ilya.TwoButtons.Question.QuestionsListFragment;
import com.TwoButtons.ilya.TwoButtons.Question.QuestionsListPresenter;

/**
 * Created by Ilya on 07.03.2018.
 */

public class MarkersQuestionsPresenter extends QuestionsListPresenter {

    MarkersQuestionsPresenter(QuestionsListFragment _markersView) {
        questionsListFragment = _markersView;
        questionsListModel = new MarkersQuestionsModel(this);
    }

    @Override
    public void receiveQuestions() {
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
