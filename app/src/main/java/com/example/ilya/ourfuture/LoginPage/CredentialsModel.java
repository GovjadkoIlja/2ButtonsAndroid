package com.example.ilya.ourfuture.LoginPage;

import com.example.ilya.ourfuture.Shared.LoginInfo;
import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ilya on 06.01.2018.
 */

public class CredentialsModel implements ICredentialsModel {

    ICredentialsPresenter credentialsPresenter;

    public CredentialsModel(ICredentialsPresenter credentialsPresenter) {
        this.credentialsPresenter = credentialsPresenter;
    }



    /*final String IP_ADDRESS = "http://192.168.1.95";
    final String PORT = "8080";
    final String URL = IP_ADDRESS + ":" + PORT;*/

    @Override
    public void checkLogin(String login, String password) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        System.out.println(login + " " + password);

        Retrofit searchRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(ServerConnection.URL)
                .build();

        loginRequest loginIntf = searchRetrofit.create(loginRequest.class);

        loginIntf.login(/*login, password*/  new Credential(login, password, 1))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::parseResponse);
        //return 0;
    }

    private void parseResponse(LoginResponse response) {

        System.out.println(response.data.userId);

        new LoginInfo(response.data.userId, response.data.roleType, response.data.accessToken);

        credentialsPresenter.isHasAccess(LoginInfo.getUserId());
    }
}
