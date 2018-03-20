package com.example.ilya.ourfuture.UserPage;

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
            userButtonsView.getPeopleList(userButtonsModel.getUserId(), layoutNumber == 1, layoutNumber == 2);
        }
    }
}
