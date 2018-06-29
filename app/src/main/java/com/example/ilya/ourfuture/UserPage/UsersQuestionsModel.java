package com.example.ilya.ourfuture.UserPage;

import com.example.ilya.ourfuture.Question.QuestionsListModel;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Question.Question;
import com.example.ilya.ourfuture.Question.QuestionsListPresenter;
import com.example.ilya.ourfuture.Question.QuestionsListResponse;
import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class UsersQuestionsModel extends QuestionsListModel {

    //QuestionsListPresenter postsPresenter;

    int userId;
    ArrayList<Question> questions;

    public UsersQuestionsModel(int _userId, QuestionsListPresenter _postsPresenter) {
        questionsListPresenter = _postsPresenter;
        userId = _userId;
    }

    public void questionClicked(int position, ArrayList<Question> questions) {

    }

    public void receiveAskedQuestions() {
        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IUsersQuestionsRequest questionsListIntf = searchRetrofit.create(IUsersQuestionsRequest.class);

        questionsListIntf.getUserAskedQuestions(new UserInfoRequest(Id.getId(), userId))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> questionsListPresenter.questionsGot(n.data));
    }

    public void receiveAnsweredQuestions() {
        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IUsersQuestionsRequest questionsListIntf = searchRetrofit.create(IUsersQuestionsRequest.class);

        questionsListIntf.getUserAnsweredQuestions(new UserInfoRequest(Id.getId(), userId))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> questionsListPresenter.questionsGot(n.data));
    }

    public void receiveFavoriteQuestions() {
        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IUsersQuestionsRequest questionsListIntf = searchRetrofit.create(IUsersQuestionsRequest.class);

        questionsListIntf.getUserFavoriteQuestions(new UserInfoRequest(Id.getId(), userId))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> questionsListPresenter.questionsGot(n.data));
    }

    public int getId() {
        return Id.getId();
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    private void parseResponse(QuestionsListResponse questionsListResponse) {

        questionsListPresenter.questionsGot(questionsListResponse.data);
    }
}
