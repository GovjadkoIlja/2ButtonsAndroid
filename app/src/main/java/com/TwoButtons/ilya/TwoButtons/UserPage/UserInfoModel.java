package com.TwoButtons.ilya.TwoButtons.UserPage;

import com.TwoButtons.ilya.TwoButtons.Shared.ErrorHandler;
import com.TwoButtons.ilya.TwoButtons.Shared.ServerConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ilya on 11.01.2018.
 */

public class UserInfoModel implements IUserInfoModel {

    /*final String IP_ADDRESS = "http://192.168.1.95";
    final String PORT = "8080";
    final String URL = IP_ADDRESS + ":" + PORT;*/

    IUserInfoPresenter userInfoPresenter;

    int id;
    UserInfo user;

    public UserInfoModel(int _id, IUserInfoPresenter _userInfoPresenter) {
        userInfoPresenter = _userInfoPresenter;
        id = _id;
    }

    @Override
    public void getUserInfo(int id, int userId) {
        Gson gson = new GsonBuilder().create();

        System.out.println(id + " " + userId);

        Retrofit searchRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(ServerConnection.URL)
                .build();

        IUserInfoRequest userInfoIntf = searchRetrofit.create(IUserInfoRequest.class);

        userInfoIntf.getUserInfo(new UserInfoRequest(id, userId))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(userInfo -> userInfoPresenter.userInfoGot(userInfo.data),
                        e -> userInfoPresenter.errorOccured(ErrorHandler.getErrorType(e)));
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getUserId() {
        return user.userId;
    }

    private void parseResponse(UserInfo userInfo) {
        System.out.println(userInfo.login);

        userInfoPresenter.userInfoGot(user);
    }
}
