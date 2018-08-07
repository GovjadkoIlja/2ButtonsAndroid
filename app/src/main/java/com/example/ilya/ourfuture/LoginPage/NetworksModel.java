package com.example.ilya.ourfuture.LoginPage;

import com.example.ilya.ourfuture.Shared.ErrorHandler;
import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.vk.sdk.VKAccessToken;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Ilya on 25.07.2018.
 */

public class NetworksModel extends LoginModel {

    public NetworksModel(NetworksPresenter networksPresenter) {
        this.loginPresenter = networksPresenter;
    }

    public void vkLogin(VKAccessToken res) {
        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IExternalLoginRequest loginIntf = searchRetrofit.create(IExternalLoginRequest.class);

        System.out.println("AAAAAAAAA");

        loginIntf.vkLogin(/*login, password*/  new VkLoginRequest(res))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::parseResponse, e -> loginPresenter.errorOccured(ErrorHandler.getErrorType(e)));
    }
}
