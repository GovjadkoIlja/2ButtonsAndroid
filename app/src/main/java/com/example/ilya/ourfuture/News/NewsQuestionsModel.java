package com.example.ilya.ourfuture.News;

import com.example.ilya.ourfuture.Shared.ErrorHandler;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.PageParams;
import com.example.ilya.ourfuture.Shared.ServerConnection;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Ilya on 04.07.2018.
 */

public class NewsQuestionsModel {

    public int offset = 0;
    public int count = PageParams.defaultQuestionsCount;
    public boolean isInProcess = false;

    public ArrayList<NewsQuestion> newsQuestion;

    NewsQuestionsPresenter newsQuestionsPresenter;

    public NewsQuestionsModel(NewsQuestionsPresenter newsQuestionsPresenter) {
        this.newsQuestionsPresenter = newsQuestionsPresenter;
    }

    public void receiveQuestions() {
        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        INewsRequest newsRequestIntf = searchRetrofit.create(INewsRequest.class);

        newsRequestIntf.getNews(new NewsRequest(Id.getId(), new PageParams(offset, count)))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> newsQuestionsPresenter.questionsGot(n.data),
                        e -> newsQuestionsPresenter.errorOccured(ErrorHandler.getErrorType(e)));
    }

    public void incrementOffset() {
        offset += count;
    }

    public boolean getIsInProcess() {
        return isInProcess;
    }

    public void setIsInProcess(boolean isInProcess) {
        this.isInProcess = isInProcess;
    }

    public void setNewsQuestion(ArrayList<NewsQuestion> newsQuestion) {
        this.newsQuestion = newsQuestion;
    }

    public ArrayList<NewsQuestion> getNewsQuestions() {
        return newsQuestion;
    }
}
