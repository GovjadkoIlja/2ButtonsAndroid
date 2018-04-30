package com.example.ilya.ourfuture.LoginPage;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Ilya on 06.01.2018.
 */

public interface ICredentialsModel {
    Observable checkLogin(String login, String password);
}
