package com.TwoButtons.ilya.TwoButtons.Markers;

import com.TwoButtons.ilya.TwoButtons.Question.QuestionsListPresenter;
import com.TwoButtons.ilya.TwoButtons.Shared.ServerConnection;
import com.TwoButtons.ilya.TwoButtons.Question.QuestionsListModel;
import com.TwoButtons.ilya.TwoButtons.Shared.ErrorHandler;
import com.TwoButtons.ilya.TwoButtons.Shared.Id;
import com.TwoButtons.ilya.TwoButtons.Question.Question;
import com.TwoButtons.ilya.TwoButtons.Shared.PageParams;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

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

        questionsListIntf.getAsked(new MarkersRequest(Id.getId(), sortType, new PageParams(offset, count)))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(questionsListResponse -> questionsListPresenter.questionsGot(1, questionsListResponse.data),
                        e -> questionsListPresenter.errorOccured(ErrorHandler.getErrorType(e)));
    }

    public void receiveUserLikedQuestions(int sortType) {
        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IGetPersonalQuestionsRequest questionsListIntf = searchRetrofit.create(IGetPersonalQuestionsRequest.class);

        questionsListIntf.getLiked(new MarkersRequest(Id.getId(), sortType, new PageParams(offset, count)))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(questionsListResponse -> questionsListPresenter.questionsGot(2, questionsListResponse.data),
                        e -> questionsListPresenter.errorOccured(ErrorHandler.getErrorType(e)));
    }

    public void receiveUserSavedQuestions(int sortType) {
        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IGetPersonalQuestionsRequest questionsListIntf = searchRetrofit.create(IGetPersonalQuestionsRequest.class);

        questionsListIntf.getSaved(new MarkersRequest(Id.getId(), sortType, new PageParams(offset, count)))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(questionsListResponse -> questionsListPresenter.questionsGot(3, questionsListResponse.data),
                        e -> questionsListPresenter.errorOccured(ErrorHandler.getErrorType(e)));
    }
}
