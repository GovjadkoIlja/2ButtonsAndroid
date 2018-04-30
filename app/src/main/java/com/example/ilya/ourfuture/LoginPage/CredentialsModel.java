package com.example.ilya.ourfuture.LoginPage;

import android.net.*;
import android.net.Credentials;

import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.reactivex.*;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ilya on 06.01.2018.
 */

public class CredentialsModel implements ICredentialsModel {

    /*final String IP_ADDRESS = "http://192.168.1.95";
    final String PORT = "8080";
    final String URL = IP_ADDRESS + ":" + PORT;*/

    @Override
    public Observable checkLogin(String login, String password) {
        Gson gson = new GsonBuilder().create();

        Retrofit searchRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(ServerConnection.URL)
                .build();

        loginRequest loginIntf = searchRetrofit.create(loginRequest.class);

        return loginIntf.login(/*login, password*/  new Credential(login, password))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
                //.subscribe(n -> System.out.println(n.toString()));
        //return 0;
    }
}
