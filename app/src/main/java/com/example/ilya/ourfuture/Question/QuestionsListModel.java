package com.example.ilya.ourfuture.Question;

import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.PageParams;
import com.example.ilya.ourfuture.Shared.ServerConnection;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

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
