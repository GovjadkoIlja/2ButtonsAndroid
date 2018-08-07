package com.example.ilya.ourfuture.Tops;

import com.example.ilya.ourfuture.Markers.IGetPersonalQuestionsRequest;
import com.example.ilya.ourfuture.Markers.MarkersRequest;
import com.example.ilya.ourfuture.Question.Question;
import com.example.ilya.ourfuture.Question.QuestionsListModel;
import com.example.ilya.ourfuture.Question.QuestionsListPresenter;
import com.example.ilya.ourfuture.Shared.ErrorHandler;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.PageParams;
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

    public void receiveTopQuestions(int type, long deltaUnixTime, boolean isOnlyNew, int sortType) {
        setIsInProcess(true);

        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println(offset + " " + count);

        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        ITopQuestionRequest questionsListIntf = searchRetrofit.create(ITopQuestionRequest.class);

        System.out.println(type + " " + questionsListPresenter.getType());

        questionsListIntf.getTop(new TopRequest(Id.getId(), deltaUnixTime, isOnlyNew, sortType, new PageParams(offset, count)))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(questionsListResponse -> questionsListPresenter.questionsGot(type, questionsListResponse.data),
                        e -> questionsListPresenter.errorOccured(ErrorHandler.getErrorType(e)));
    }
}
