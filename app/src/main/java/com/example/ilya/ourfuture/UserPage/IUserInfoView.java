package com.example.ilya.ourfuture.UserPage;

/**
 * Created by Ilya on 11.01.2018.
 */

public interface IUserInfoView {
    void userInfoGot(UserInfo userInfo);
    void setLogin(String login);
    void setAgeSex(int age, String sex);
    void setDescription(String description);
    void setButtons(boolean isMine, boolean heFollowed, boolean youFollowed);
}
