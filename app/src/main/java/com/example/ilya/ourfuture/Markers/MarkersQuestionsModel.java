package com.example.ilya.ourfuture.Markers;

import com.example.ilya.ourfuture.Question.QuestionsListModel;
import com.example.ilya.ourfuture.Question.QuestionsListPresenter;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Question.Question;
import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.example.ilya.ourfuture.UserPage.IUsersQuestionsRequest;
import com.example.ilya.ourfuture.UserPage.UserInfoRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ilya on 07.03.2018.
 */

public class MarkersQuestionsModel extends QuestionsListModel {

    ArrayList<Question> questions;

    public MarkersQuestionsModel(QuestionsListPresenter _questionsPresenter) {
        questionsListPresenter = _questionsPresenter;
    }

    public void receiveUserAskedQuestions(int sortType) {
        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IGetPersonalQuestionsRequest questionsListIntf = searchRetrofit.create(IGetPersonalQuestionsRequest.class);

        questionsListIntf.getAsked(new MarkersRequest(Id.getId(), sortType))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(questionsListResponse -> questionsListPresenter.questionsGot(questionsListResponse.data));
    }

    public void receiveUserLikedQuestions(int sortType) {
        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IGetPersonalQuestionsRequest questionsListIntf = searchRetrofit.create(IGetPersonalQuestionsRequest.class);

        questionsListIntf.getLiked(new MarkersRequest(Id.getId(), sortType))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(questionsListResponse -> questionsListPresenter.questionsGot(questionsListResponse.data));
    }

    public void receiveUserSavedQuestions(int sortType) {
        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IGetPersonalQuestionsRequest questionsListIntf = searchRetrofit.create(IGetPersonalQuestionsRequest.class);

        questionsListIntf.getSaved(new MarkersRequest(Id.getId(), sortType))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(questionsListResponse -> questionsListPresenter.questionsGot(questionsListResponse.data));
    }

    private void parseResponse(JsonElement s) {
        Type questionsListType = new TypeToken<ArrayList<Question>>() {}.getType();

        Gson gson = new Gson();

        questions = gson.fromJson(s, questionsListType);

        questionsListPresenter.questionsGot(questions);
    }
}
