package com.example.ilya.ourfuture.LoginPage;

import com.example.ilya.ourfuture.Shared.Id;

/**
 * Created by Ilya on 06.01.2018.
 */

public class CredentialsPresenter extends LoginPresenter implements ICredentialsPresenter {

    /*ICredentialsView credentialsView;
    ICredentialsModel credentialsModel;*/

    public CredentialsPresenter(LoginFragment view) {
        loginFragment = view;
        loginModel = new CredentialsModel(this);
    }

    @Override
    public void getId(String login, String password) {
        ((CredentialsModel) loginModel).checkLogin(login, password);//.subscribe(n -> makeDecision(((int)Math.round((double)n))));
        //makeDecision(1); //ПРОСТО ЗАГЛУШКА, РАСКОММЕНТИТЬ СТРОКУ ВЫШЕ
    }
}
