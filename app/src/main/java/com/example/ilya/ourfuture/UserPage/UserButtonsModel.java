package com.example.ilya.ourfuture.UserPage;

import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.example.ilya.ourfuture.UsersList.FollowRequest;
import com.example.ilya.ourfuture.UsersList.IFollowRequest;
import com.example.ilya.ourfuture.UsersList.Person;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Ilya on 16.01.2018.
 */

public class UserButtonsModel implements IUserButtonsModel {

    int userId;
    UserInfo user;

    @Override
    public void subscribe() {
        user.isYouFollowed = true;

        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IFollowRequest followRequestIntf = searchRetrofit.create(IFollowRequest.class);

        followRequestIntf.follow(new FollowRequest(Id.getId(), user.userId))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(System.out::println);
    }

    @Override
    public void unsubscribe() {
        user.isYouFollowed = false;

        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IFollowRequest followRequestIntf = searchRetrofit.create(IFollowRequest.class);

        followRequestIntf.unfollow(new FollowRequest(Id.getId(), user.userId))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(System.out::println);
    }

    public UserButtonsModel(int _userId) {
        userId = _userId;
    }

    /*@Override
    public void setDescription(int id, int userId) {
        id = id;
        userId = userId;
    }*/

    /*@Override
    public int getId() {
        return id;
    }*/

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public void saveUserInfo(UserInfo userInfo) {
        user = userInfo;
    }

    @Override
    public UserInfo getUserInfo() {
        return user;
    }


}
