package com.TwoButtons.ilya.TwoButtons.UserPage;

/**
 * Created by Ilya on 16.01.2018.
 */

public class UserButtonsPresenter implements IUserButtonsPresenter {

    IUserButtonsView userButtonsView;
    IUserButtonsModel userButtonsModel;

    public UserButtonsPresenter(int userId, IUserButtonsView _userButtonsView) {
        userButtonsView = _userButtonsView;
        userButtonsModel = new UserButtonsModel(userId);
    }

    @Override
    public void layoutClicked(int layoutNumber) {
        if ((layoutNumber == 1) || (layoutNumber == 2)) {
            userButtonsView.getPeopleList(userButtonsModel.getUserId(), layoutNumber);
        }
    }

    @Override
    public int getUserId() {
        return userButtonsModel.getUserId();
    }

    @Override
    public void saveUserInfo(UserInfo userInfo) {
        userButtonsModel.saveUserInfo(userInfo);
    }

    @Override
    public void updateFollow() {
        boolean isYouFollowed = userButtonsModel.getUserInfo().isYouFollowed;
        userButtonsView.setButtonFollow(false, !isYouFollowed);

        UserInfo userInfo = userButtonsModel.getUserInfo();

        if (isYouFollowed) {
            userButtonsModel.unsubscribe();
            userInfo.followersCount--;
            userButtonsView.setButtonsValues(userInfo);
        }
        else {
            userButtonsModel.subscribe();
            userInfo.followersCount++;
            userButtonsView.setButtonsValues(userInfo);
        }

    }
}
