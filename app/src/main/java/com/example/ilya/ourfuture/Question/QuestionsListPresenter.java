package com.example.ilya.ourfuture.Question;

import java.util.ArrayList;

/**
 * Created by Ilya on 27.04.2018.
 */

public abstract class QuestionsListPresenter {

    public int type;

    public QuestionsListFragment questionsListFragment;
    public QuestionsListModel questionsListModel;

    public void questionsGot(int type, ArrayList<Question> questions) {

        if (questionsListFragment == null || this.type != type)
            return;

        questionsListModel.setIsInProcess(false);
        if (questionsListModel.getDeletionAfterReceiving()) {
            questionsListModel.deleteQuestions();
            questionsListModel.setDeletionAfterReceiving(false);
        }

        if (questions.size() == 0) {
            questionsListModel.setListFull(true);
        }

        ArrayList<Question> oldQuestions = questionsListModel.getQuestions();

        if (questionsListFragment == null) {
            System.out.println("DELETED!");
            return;
        }

        if ((oldQuestions == null) || (oldQuestions.size() == 0)) {
            if (questions.size() == 0) {
                errorOccured(3);
                return;
            } else {
                questionsListModel.setQuestions(questions);
                questionsListFragment.representQuestions(questions);
            }
        } else {
            System.out.println(questions.size());
            oldQuestions.addAll(questions);
            questionsListModel.setQuestions(oldQuestions);
            questionsListFragment.addNewQuestions(questions);
        }

        questionsListModel.incrementOffset();
    }

    public void errorOccured(int errorType) {
        System.out.println(errorType + " AAAAAA");

        questionsListFragment.errorOccured(errorType);

        switch (errorType) {
            case 1:

                System.out.println("Ошибка на сервере");
                break;
        }
    }

    public abstract void receiveQuestions();

    public int getType() {
        return type;
    }

    public void setType(int type) {
        if (this.type != type) {
            questionsListModel.setListFull(false);
            questionsListModel.setIsInProcess(false);
            questionsListModel.setDeletionAfterReceiving(true);
            questionsListModel.clearOffset();
            this.type = type;
            receiveQuestions();
        }
    }
}
