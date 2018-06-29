package com.example.ilya.ourfuture.Followers;

import com.example.ilya.ourfuture.UsersList.UsersListFragment;
import com.example.ilya.ourfuture.UsersList.UsersListPresenter;

/**
 * Created by Ilya on 10.06.2018.
 */

public class FollowersPresenter extends UsersListPresenter {

    public FollowersPresenter(UsersListFragment usersListFragment, int userId) {
        this.usersListFragment = usersListFragment;

        usersListModel = new FollowersModel(this, userId);
    }

    public void receiveUsersList(int listType) {
        if (listType == 1)
            ((FollowersModel)usersListModel).receiveFollowers();
        else
            ((FollowersModel)usersListModel).receiveFollowTo();
    }
}
