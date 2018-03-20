package com.example.ilya.ourfuture.RegistrationPage;

import io.reactivex.Observable;

/**
 * Created by Ilya on 09.01.2018.
 */

public interface IRegisterPropertiesModel {
    void checkLogin(String login);
    void doRegistration(String login, String password, String phone, String email, String age, int sex);
}
