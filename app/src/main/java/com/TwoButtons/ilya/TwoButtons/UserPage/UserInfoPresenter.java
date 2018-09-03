package com.TwoButtons.ilya.TwoButtons.UserPage;

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
        System.out.println(user.login);
        userInfoView.userInfoGot(user);
        representUserInfo(user);
    }

    @Override
    public void errorOccured(int errorType) {
        String toastString = "Произошла неизвестная ошибка. Попробуйте снова";
        switch (errorType) {
            case 1:
                toastString = "Произошла ошибка. Повторите попытку позже";
                break;

            case 2:
                toastString = "Проверьте соединение с Интернетом и повторите попытку";
                break;
        }

        userInfoView.showToast(toastString);
    }

    private void representUserInfo(UserInfo user) {
        //userInfoView.setLogin(user.login);

        String sex;
        if (user.sexType == 1)
            sex = "M";
        else
            sex = "Ж";

        userInfoView.setAgeSex(user.age, sex);

        //userInfoView.setButtons(user.userId == userInfoModel.id, user.isHeFollowed, user.isYouFollowed);

        userInfoView.setDescription(user.description);
    }

}
