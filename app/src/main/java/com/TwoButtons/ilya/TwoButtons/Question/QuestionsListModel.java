package com.TwoButtons.ilya.TwoButtons.Question;

import com.TwoButtons.ilya.TwoButtons.Shared.PageParams;

import java.util.ArrayList;

/**
 * Created by Ilya on 02.06.2018.
 */

public abstract class QuestionsListModel {

    public ArrayList<Question> questions;

    public int offset = 0;
    public int count = PageParams.defaultQuestionsCount;
    public boolean isInProcess = false;
    public boolean deleteAfterReceiving = false;
    public boolean isListFull = false;

    public QuestionsListPresenter questionsListPresenter;

    public void incrementOffset() {
        offset += count;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public boolean getIsInProcess() {
        return isInProcess;
    }

    public void setIsInProcess(boolean isInProcess) {
        this.isInProcess = isInProcess;
    }

    public void deleteQuestions() {
        System.out.println("DELETE!");

        if (questions != null)
            questions.clear();
    }

    public void setDeletionAfterReceiving(boolean isDelete) {
        deleteAfterReceiving = isDelete;
    }

    public boolean getDeletionAfterReceiving() {
        return deleteAfterReceiving;
    }

    public void clearOffset() {
        offset = 0;
    }

    public void setListFull(boolean isListFull) {
        this.isListFull = isListFull;
    }

    public boolean getListFull() {
        return isListFull;
    }
}
