package com.TwoButtons.ilya.TwoButtons.UserPage;

/**
 * Created by Ilya on 11.01.2018.
 */

public interface IUserInfoView {
    void userInfoGot(UserInfo userInfo);
    void setAgeSex(int age, String sex);
    void setDescription(String description);
    void showToast(String toastString);
}
