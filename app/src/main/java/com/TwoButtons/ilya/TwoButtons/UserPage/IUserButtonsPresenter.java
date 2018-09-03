package com.TwoButtons.ilya.TwoButtons.UserPage;

/**
 * Created by Ilya on 16.01.2018.
 */

public interface IUserButtonsPresenter {
    void layoutClicked(int layoutNumber);
    int getUserId();
    void saveUserInfo(UserInfo userInfo);
    void updateFollow();
}
