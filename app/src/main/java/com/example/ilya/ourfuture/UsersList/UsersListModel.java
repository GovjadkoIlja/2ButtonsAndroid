package com.example.ilya.ourfuture.UsersList;

import com.example.ilya.ourfuture.Question.AddAnswerRequest;
import com.example.ilya.ourfuture.Question.IActionWithQuestionRequest;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.ServerConnection;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Ilya on 10.06.2018.
 */

public abstract class UsersListModel {
    public UsersListPresenter usersListPresenter;

    public void subscribe(Person user) {
        user.isYouFollowed = true;

        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IFollowRequest followRequestIntf = searchRetrofit.create(IFollowRequest.class);

        followRequestIntf.follow(new FollowRequest(Id.getId(), user.userId))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(System.out::println);
    }

    public void unsubscribe(Person user) {
        user.isYouFollowed = false;

        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IFollowRequest followRequestIntf = searchRetrofit.create(IFollowRequest.class);

        followRequestIntf.unfollow(new FollowRequest(Id.getId(), user.userId))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(System.out::println);
    }
}
