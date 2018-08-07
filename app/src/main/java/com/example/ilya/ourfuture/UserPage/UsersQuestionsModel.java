package com.example.ilya.ourfuture.UserPage;

import com.example.ilya.ourfuture.Question.QuestionsListModel;
import com.example.ilya.ourfuture.Shared.ErrorHandler;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Question.Question;
import com.example.ilya.ourfuture.Question.QuestionsListPresenter;
import com.example.ilya.ourfuture.Question.QuestionsListResponse;
import com.example.ilya.ourfuture.Shared.PageParams;
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

    int userId;

    public UsersQuestionsModel(int _userId, QuestionsListPresenter _postsPresenter) {
        questionsListPresenter = _postsPresenter;
        userId = _userId;
    }

    public void receiveAskedQuestions() {
        setIsInProcess(true);

        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println(offset + " " + count);

        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IUsersQuestionsRequest questionsListIntf = searchRetrofit.create(IUsersQuestionsRequest.class);

        questionsListIntf.getUserAskedQuestions(new UserQuestionsRequest(Id.getId(), userId, new PageParams(offset, count)))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> questionsListPresenter.questionsGot(1, n.data),
                        e -> questionsListPresenter.errorOccured(ErrorHandler.getErrorType(e)));
    }

    public void receiveAnsweredQuestions() {
        setIsInProcess(true);

        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println(offset + " " + count);

        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IUsersQuestionsRequest questionsListIntf = searchRetrofit.create(IUsersQuestionsRequest.class);

        questionsListIntf.getUserAnsweredQuestions(new UserQuestionsRequest(Id.getId(), userId, new PageParams(offset, count)))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> questionsListPresenter.questionsGot(2, n.data),
                        e -> questionsListPresenter.errorOccured(ErrorHandler.getErrorType(e)));
    }

    public void receiveFavoriteQuestions() {
        setIsInProcess(true);

        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println(offset + " " + count);

        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IUsersQuestionsRequest questionsListIntf = searchRetrofit.create(IUsersQuestionsRequest.class);

        questionsListIntf.getUserFavoriteQuestions(new UserQuestionsRequest(Id.getId(), userId, new PageParams(offset, count)))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> questionsListPresenter.questionsGot(3, n.data),
                        e -> questionsListPresenter.errorOccured(ErrorHandler.getErrorType(e)));
    }

    public int getId() {
        return Id.getId();
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}
