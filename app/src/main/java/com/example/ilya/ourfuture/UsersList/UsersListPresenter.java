package com.example.ilya.ourfuture.UsersList;

import java.util.ArrayList;

/**
 * Created by Ilya on 08.06.2018.
 */

public abstract class UsersListPresenter {

    public UsersListFragment usersListFragment;
    public UsersListModel usersListModel;

    public void usersListGot(ArrayList<Person> usersList) {
        usersListFragment.representUsersList(usersList);
    }

    public void subscribeButtonClicked(Person user) {
        if (user.isYouFollowed)
            usersListModel.unsubscribe(user);
        else
            usersListModel.subscribe(user);
    }
}
