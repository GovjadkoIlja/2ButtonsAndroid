package com.example.ilya.ourfuture.LoginPage;

/**
 * Created by Ilya on 06.01.2018.
 */

public interface ICredentialsView {
    void onLoginButtonClick();
    void openApplication(int id, String login);
    void denyAccess();
}
