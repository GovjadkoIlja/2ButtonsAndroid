package com.example.ilya.ourfuture.UserPage;

/**
 * Created by Ilya on 11.01.2018.
 */

public interface IUserInfoPresenter {
    void getUserInfo(int id, int userId);
    void userInfoGot(UserInfo user);
}
