package com.example.ilya.ourfuture.Followers;

import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.example.ilya.ourfuture.UsersList.UsersListModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Ilya on 10.06.2018.
 */

public class FollowersModel extends UsersListModel {
    //FollowersPresenter followersPresenter;
    int userId;

    public FollowersModel(FollowersPresenter followersPresenter, int userId) {
        this.usersListPresenter = followersPresenter;
        this.userId = userId;
    }

    public void receiveFollowers() {

        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IFollowersRequest postsIntf = searchRetrofit.create(IFollowersRequest.class);

        postsIntf.getFollowers(new FollowersRequest(Id.getId(), userId, ""))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> usersListPresenter.usersListGot(n.data));
    }

    public void receiveFollowTo() {

        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IFollowersRequest postsIntf = searchRetrofit.create(IFollowersRequest.class);

        postsIntf.getFollowTo(new FollowersRequest(Id.getId(), userId, ""))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> usersListPresenter.usersListGot(n.data));
    }

}
