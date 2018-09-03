package com.TwoButtons.ilya.TwoButtons.UserPage;

/**
 * Created by Ilya on 16.01.2018.
 */

public interface IUserButtonsModel {
    //void setDescription(int id, int userId);
    //int getId();
    int getUserId();
    void saveUserInfo(UserInfo userInfo);
    UserInfo getUserInfo();
    void subscribe();
    void unsubscribe();
}
