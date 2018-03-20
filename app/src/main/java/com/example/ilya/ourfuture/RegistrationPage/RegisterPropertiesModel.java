package com.example.ilya.ourfuture.RegistrationPage;

import com.example.ilya.ourfuture.RegistrationPage.DoRegistrationRequest;
import com.example.ilya.ourfuture.RegistrationPage.IRegisterPropertiesModel;
import com.example.ilya.ourfuture.RegistrationPage.IRegisterPropertiesPresenter;
import com.example.ilya.ourfuture.RegistrationPage.checkLoginRequest;
import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ilya on 09.01.2018.
 */

public class RegisterPropertiesModel implements IRegisterPropertiesModel {

    /*final String IP_ADDRESS = "http://192.168.1.95";
    final String PORT = "8080";
    final String URL = IP_ADDRESS + ":" + PORT;*/

    IRegisterPropertiesPresenter registerPropertiesPresenter;

    RegisterPropertiesModel(IRegisterPropertiesPresenter _registerPropertiesPresenter) {
        registerPropertiesPresenter = _registerPropertiesPresenter;
    }

    @Override
    public void checkLogin(String login) {
        Gson gson = new GsonBuilder().create();

        Retrofit searchRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(ServerConnection.URL)
                .build();

        checkLoginRequest checkLoginIntf = searchRetrofit.create(checkLoginRequest.class);

        checkLoginIntf.checkLogin(login)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> registerPropertiesPresenter.getLoginValidation((int)Math.round((double)n)));

    }

    @Override
    public void doRegistration(String login, String password, String phone, String description, String age, int sex) {
        Gson gson = new GsonBuilder().create();

        Retrofit searchRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(ServerConnection.URL)
                .build();

        DoRegistrationRequest doRegistrationIntf = searchRetrofit.create(DoRegistrationRequest.class);

        doRegistrationIntf.addUser(login, Integer.parseInt(password), phone, description, Integer.parseInt(age), sex)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> registerPropertiesPresenter.registrationDone((int)Math.round((double)n)));
    }
}
