package com.example.ilya.ourfuture.LoginPage;

import com.example.ilya.ourfuture.Shared.ErrorHandler;
import com.example.ilya.ourfuture.Shared.ServerConnection;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Ilya on 06.01.2018.
 */

public class CredentialsModel extends LoginModel implements ICredentialsModel {

    //ICredentialsPresenter credentialsPresenter;

    public CredentialsModel(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    @Override
    public void checkLogin(String login, String password) {

        /*Gson gson = new GsonBuilder()
                .setLenient()
                .create();*/

        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        loginRequest loginIntf = searchRetrofit.create(loginRequest.class);

        loginIntf.login(/*login, password*/  new Credential(login, password, 1))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::parseResponse, e -> loginPresenter.errorOccured(ErrorHandler.getErrorType(e)));
        //return 0;
    }


}
