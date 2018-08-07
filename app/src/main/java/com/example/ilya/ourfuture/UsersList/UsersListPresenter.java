package com.example.ilya.ourfuture.UsersList;

import java.util.ArrayList;

/**
 * Created by Ilya on 08.06.2018.
 */

public abstract class UsersListPresenter {

    public UsersListFragment usersListFragment;
    public UsersListModel usersListModel;

    public void usersListGot(ArrayList<Person> usersList) {
        System.out.println(usersListFragment + " " + usersList + " CCCCCCCCC");

        if (usersList == null || usersListFragment == null) {
            System.out.println("DELETED!");
            return;
        }

        usersListFragment.representUsersList(usersList);

        if (usersList.size() == 0)
            errorOccured(3);
    }

    public void errorOccured(int errorType) {
        System.out.println(errorType + " AAAAAA");

        usersListFragment.errorOccured(errorType);

        switch (errorType) {
            case 1:

                System.out.println("Ошибка на сервере");
                break;
        }
    }
}
