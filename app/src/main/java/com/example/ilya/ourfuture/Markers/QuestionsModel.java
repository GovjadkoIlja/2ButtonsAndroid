package com.example.ilya.ourfuture.Markers;

import com.example.ilya.ourfuture.QuestionPage.Question;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.ServerConnection;
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

public class QuestionsModel implements IQuestionsModel {

    ArrayList<Question> questions;

    IQuestionsPresenter questionsPresenter;

    public QuestionsModel(IQuestionsPresenter _questionsPresenter) {
        questionsPresenter = _questionsPresenter;
    }

    @Override
    public void receiveQuestions(int type) {
        Gson gson = new GsonBuilder().create();

        Retrofit searchRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(ServerConnection.URL)
                .build();

        IGetQuestionsRequest questionsIntf = searchRetrofit.create(IGetQuestionsRequest.class);

        switch (type) {
            case 1:
                questionsIntf.getMy(Id.getId())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(n -> parseResponse(n));
                break;

            case 2:
                questionsIntf.getFavorites(Id.getId())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(n -> parseResponse(n));
                break;

            case 3:
                questionsIntf.getHistory(Id.getId())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(n -> parseResponse(n));
        }
    }


    private void parseResponse(JsonElement s) {
        Type questionsListType = new TypeToken<ArrayList<Question>>() {}.getType();

        Gson gson = new Gson();

        questions = gson.fromJson(s, questionsListType);

        questionsPresenter.questionsGot(questions);
    }
}
