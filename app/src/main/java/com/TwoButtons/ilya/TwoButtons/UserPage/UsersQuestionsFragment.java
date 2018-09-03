package com.TwoButtons.ilya.TwoButtons.UserPage;

import android.os.Bundle;

import com.TwoButtons.ilya.TwoButtons.Question.QuestionsListFragment;
import com.TwoButtons.ilya.TwoButtons.Shared.Id;

public class UsersQuestionsFragment extends QuestionsListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();

        int userId = args.getInt("userId", Id.getId());

        questionsListPresenter = new UsersQuestionsPresenter(userId, this);

        questionsListPresenter.setType(1);
    }

    public void questionsTypeChanged(int type, boolean isFromErrorFragment, int userId) { //as well will be executed authomatically from the header
        if (isFromErrorFragment)
            questionsListPresenter = new UsersQuestionsPresenter(userId, this);

        deleteQuestions();

        questionsListPresenter.setType(type);
        //questionsListPresenter.receiveQuestions();
    }
}

