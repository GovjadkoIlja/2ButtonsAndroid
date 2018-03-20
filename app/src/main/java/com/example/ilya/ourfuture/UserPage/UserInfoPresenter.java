package com.example.ilya.ourfuture.UserPage;

/**
 * Created by Ilya on 11.01.2018.
 */

public class UserInfoPresenter implements IUserInfoPresenter {

    IUserInfoView userInfoView;
    UserInfoModel userInfoModel;

    public UserInfoPresenter(int id, IUserInfoView _userInfoView) {
        userInfoView = _userInfoView;
        userInfoModel = new UserInfoModel(id, this);
    }

    @Override
    public void getUserInfo(int id, int userId) {
        userInfoModel.getUserInfo(id, userId);
    }

    @Override
    public void userInfoGot(UserInfo user) {
        representUserInfo(user);
    }



    private void representUserInfo(UserInfo user) {
        userInfoView.setLogin(user.login);

        String sex;
        if (user.sex == 1)
            sex = "M";
        else
            sex = "Ж";

        userInfoView.setAgeSex(user.age, sex);

        userInfoView.setButtons(user.userId == userInfoModel.id, user.heFollowed == 1, user.youFollowed == 1);

        userInfoView.setDescription(user.description);
    }

}
