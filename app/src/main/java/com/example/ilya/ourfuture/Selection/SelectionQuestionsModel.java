package com.example.ilya.ourfuture.Selection;

import com.example.ilya.ourfuture.Markers.MarkersRequest;
import com.example.ilya.ourfuture.Question.Question;
import com.example.ilya.ourfuture.Question.QuestionsListModel;
import com.example.ilya.ourfuture.Question.QuestionsListPresenter;
import com.example.ilya.ourfuture.Shared.ErrorHandler;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.PageParams;
import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.example.ilya.ourfuture.Tops.ITopQuestionRequest;
import com.example.ilya.ourfuture.Tops.TopRequest;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Ilya on 05.06.2018.
 */

public class SelectionQuestionsModel extends QuestionsListModel {
    ArrayList<Question> questions;

    public SelectionQuestionsModel(QuestionsListPresenter _questionsPresenter) {
        questionsListPresenter = _questionsPresenter;
    }

    public void receiveSelectionQuestions() {
        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        ISelectionQuestionRequest questionsListIntf = searchRetrofit.create(ISelectionQuestionRequest.class);

        questionsListIntf.getSelection(new MarkersRequest(Id.getId(), 1, new PageParams(offset, count)))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(questionsListResponse -> questionsListPresenter.questionsGot(1, questionsListResponse.data),
                        e -> questionsListPresenter.errorOccured(ErrorHandler.getErrorType(e)));
    }
}
