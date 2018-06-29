package com.example.ilya.ourfuture.Question;

import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.ServerConnection;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Ilya on 02.06.2018.
 */

public abstract class QuestionsListModel {

    public QuestionsListPresenter questionsListPresenter;
}
