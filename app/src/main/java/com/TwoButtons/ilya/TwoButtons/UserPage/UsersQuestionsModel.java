package com.TwoButtons.ilya.TwoButtons.UserPage;

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
        System.out.println(offset + " " + count + " " + Id.getId() + " " + userId);

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
