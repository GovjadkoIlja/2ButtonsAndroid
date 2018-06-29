package com.example.ilya.ourfuture.CreateQuestion;

import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ilya on 24.06.2018.
 */

public class CreateQuestionModel {

    public void createQuestion(CreateQuestionRequest createQuestionRequest) {
        Gson gson = new GsonBuilder().create();

        Retrofit searchRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(ServerConnection.URL)
                .build();

        ICreateQuestionRequest createQuestionIntf = searchRetrofit.create(ICreateQuestionRequest.class);

        createQuestionIntf.createQuestion(createQuestionRequest)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(System.out::println);
    }
}
