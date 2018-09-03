package com.TwoButtons.ilya.TwoButtons.UserPage;

import com.TwoButtons.ilya.TwoButtons.Question.QuestionsListFragment;
import com.TwoButtons.ilya.TwoButtons.Question.QuestionsListPresenter;

public class UsersQuestionsPresenter extends QuestionsListPresenter {

    UsersQuestionsPresenter(int userId, QuestionsListFragment _postsView) {
        questionsListFragment = _postsView;
        questionsListModel = new UsersQuestionsModel(userId, this);
    }


    @Override
    public void receiveQuestions() {
        System.out.println(type);

        if (questionsListModel.getIsInProcess() || questionsListModel.getListFull())
            return;

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
