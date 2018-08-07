package com.example.ilya.ourfuture.LoginPage;

import com.example.ilya.ourfuture.Shared.Id;

/**
 * Created by Ilya on 25.07.2018.
 */

public abstract class LoginModel {

    LoginPresenter loginPresenter;

    public void parseResponse(LoginResponse response) {

        System.out.println(response.data.token.userId);

        /*Id.setId(response.data.user.userId);
        Id.setSmallAvatarLink(response.data.user.largeAvatarUrl);
        Id.setLogin(response.data.user.login);*/

        //new LoginInfo(response.data.token.userId, response.data.token.roleType, response.data.token.accessToken);

        System.out.println(Id.getId());

        loginPresenter.isHasAccess(response);
    }
}
