package com.example.ilya.ourfuture.Tops;

import com.example.ilya.ourfuture.Markers.IGetPersonalQuestionsRequest;
import com.example.ilya.ourfuture.Markers.MarkersRequest;
import com.example.ilya.ourfuture.Question.Question;
import com.example.ilya.ourfuture.Question.QuestionsListModel;
import com.example.ilya.ourfuture.Question.QuestionsListPresenter;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.ServerConnection;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Ilya on 04.06.2018.
 */

public class TopQuestionsModel extends QuestionsListModel {
    ArrayList<Question> questions;

    public TopQuestionsModel(QuestionsListPresenter _questionsPresenter) {
        questionsListPresenter = _questionsPresenter;
    }

    public void receiveTopQuestions(long deltaUnixTime, boolean isOnlyNew, int sortType) {
        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        ITopQuestionRequest questionsListIntf = searchRetrofit.create(ITopQuestionRequest.class);

        questionsListIntf.getTop(new TopRequest(Id.getId(), deltaUnixTime, isOnlyNew, sortType))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(questionsListResponse -> questionsListPresenter.questionsGot(questionsListResponse.data));
    }
}
