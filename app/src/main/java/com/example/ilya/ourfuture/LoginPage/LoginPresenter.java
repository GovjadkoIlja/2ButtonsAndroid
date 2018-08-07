package com.example.ilya.ourfuture.LoginPage;

import com.example.ilya.ourfuture.Shared.Id;

/**
 * Created by Ilya on 25.07.2018.
 */

public abstract class LoginPresenter {

    LoginFragment loginFragment;
    LoginModel loginModel;

    public void isHasAccess(LoginResponse response) { //Обработать недоступность сервера

        int userId = response.data.user.userId;

        if (userId > 0) {
            //Id.setId(n);
            new Id(response.data.user.userId, response.data.user.smallAvatarUrl, response.data.user.login,
                    response.data.token.accessToken, response.data.token.refreshToken, response.data.token.roleType);

            loginFragment.saveCredentials();
            loginFragment.openApplication(userId, response.data.user.login);


        }
        else
            loginFragment.denyAccess();
        /*System.out.println(n);

        return n;*/
    }

    public void errorOccured(int errorType) {
        System.out.println("AAAAAAAAAA " + errorType);
    }
}
