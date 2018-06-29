package com.example.ilya.ourfuture.QuestionPage;

import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Question.Question;
import com.example.ilya.ourfuture.Question.QuestionsList;
import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ilya on 10.02.2018.
 */

public class QuestionHeaderModel implements IQuestionHeaderModel {

    /*final String IP_ADDRESS = "http://192.168.1.95";
    final String PORT = "8080";
    final String URL = IP_ADDRESS + ":" + PORT;*/

    IQuestionHeaderPresenter questionHeaderPresenter;
    int position;
    ArrayList<Question> questions;

    QuestionHeaderModel(int position, ArrayList<Question> questions, IQuestionHeaderPresenter _questionHeaderPresenter) {
        questionHeaderPresenter = _questionHeaderPresenter;

        this.position = position;
        this.questions = questions;
    }

    @Override
    public Question getNextQuestion() {
        return QuestionsList.getNextQuestion();
    }

    @Override
    public void feedbackChanged(int newFeedback) {

        Question question = getNextQuestion();

        question.yourFeedbackType = newFeedback;

        Gson gson = new GsonBuilder().create();

        Retrofit searchRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(ServerConnection.URL)
                .build();

        ISaveFeedback saveFeedbackIntf = searchRetrofit.create(ISaveFeedback.class);

        saveFeedbackIntf.saveFeedback(Id.getId(), question.questionId, newFeedback)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> System.out.println(n));
    }

    @Override
    public void favoritesChanged() {
        Question question = getNextQuestion();
        question.isInFavorites = !question.isInFavorites;

        System.out.println(question.isInFavorites);

        Gson gson = new GsonBuilder().create();

        Retrofit searchRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(ServerConnection.URL)
                .build();

        ISaveFavorites saveFavoritesIntf = searchRetrofit.create(ISaveFavorites.class);

        saveFavoritesIntf.saveFavorites(Id.getId(), question.questionId, question.isInFavorites)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> System.out.println(n));

    }
}
