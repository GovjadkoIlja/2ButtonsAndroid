package com.example.ilya.ourfuture.Question;

import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.ServerConnection;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Ilya on 22.06.2018.
 */

public class QuestionModel {
    public QuestionPresenter questionPresenter;

    public QuestionModel(QuestionPresenter questionPresenter) {
        this.questionPresenter = questionPresenter;
    }

    public void addAnswer(Question question, int answer) {
        question.yourAnswerType = answer;
        if (answer == 1)
            question.options.get(0).voters++;
        else
            question.options.get(1).voters++;

        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IActionWithQuestionRequest addAnswerIntf = searchRetrofit.create(IActionWithQuestionRequest.class);

        addAnswerIntf.addAnswer(new AddAnswerRequest(Id.getId(), question.questionId, answer))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(System.out::println);
    }

    public void addFeedback(Question question, int feedback) {
        updateFeedbacksAmounts(question, feedback);
        question.yourFeedbackType = feedback;

        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IActionWithQuestionRequest addFeedbackIntf = searchRetrofit.create(IActionWithQuestionRequest.class);

        addFeedbackIntf.addFeedback(new AddFeedbackRequest(Id.getId(), question.questionId, feedback))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(System.out::println);
    }

    public void addFavorites(Question question, boolean isInFavorites) {
        System.out.println(isInFavorites + " AAA");

        question.isInFavorites = isInFavorites;

        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IActionWithQuestionRequest addFeedbackIntf = searchRetrofit.create(IActionWithQuestionRequest.class);

        addFeedbackIntf.addFavorites(new AddFavoritesRequest(Id.getId(), question.questionId, isInFavorites))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(System.out::println);
    }

    private void updateFeedbacksAmounts(Question question, int feedback) {
        if (question.yourFeedbackType == 1)
            question.likesCount--;
        else if (question.yourFeedbackType == -1)
            question.dislikesCount--;

        if (feedback == 1)
            question.likesCount++;
        else if (feedback == -1)
            question.dislikesCount++;
    }
}
