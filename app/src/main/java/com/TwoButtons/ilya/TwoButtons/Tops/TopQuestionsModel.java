package com.TwoButtons.ilya.TwoButtons.Tops;

import com.TwoButtons.ilya.TwoButtons.Question.Question;
import com.TwoButtons.ilya.TwoButtons.Question.QuestionsListPresenter;
import com.TwoButtons.ilya.TwoButtons.Shared.ErrorHandler;
import com.TwoButtons.ilya.TwoButtons.Shared.PageParams;
import com.TwoButtons.ilya.TwoButtons.Shared.ServerConnection;
import com.TwoButtons.ilya.TwoButtons.Question.QuestionsListModel;
import com.TwoButtons.ilya.TwoButtons.Shared.Id;

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
