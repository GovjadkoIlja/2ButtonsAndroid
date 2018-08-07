package com.example.ilya.ourfuture.LoginPage;

import io.reactivex.*;

/**
 * Created by Ilya on 06.01.2018.
 */

public interface ICredentialsPresenter {
    void getId(String login, String password);

    //void isHasAccess(int n, String login);
    void errorOccured(int errorType);
}
