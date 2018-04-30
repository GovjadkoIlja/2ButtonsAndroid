package com.example.ilya.ourfuture.LoginPage;

import com.example.ilya.ourfuture.Shared.Id;

/**
 * Created by Ilya on 06.01.2018.
 */

public class CredentialsPresenter implements ICredentialsPresenter {

    ICredentialsView credentialsView;
    ICredentialsModel credentialsModel;

    public CredentialsPresenter(ICredentialsView view) {
        credentialsView = view;
        credentialsModel = new CredentialsModel();
    }

    @Override
    public void getId(String login, String password) {
        credentialsModel.checkLogin(login, password).subscribe(n -> makeDecision(((int)Math.round((double)n))));
        //makeDecision(1); //ПРОСТО ЗАГЛУШКА, РАСКОММЕНТИТЬ СТРОКУ ВЫШЕ
    }

    private void makeDecision(int n) { //Обработать недоступность сервера

        if (n > 0) {
            Id.setId(n);
            credentialsView.openApplication(n);
        }
        else
            credentialsView.denyAccess();
        /*System.out.println(n);

        return n;*/
    }
}
