package com.example.ilya.ourfuture.UsersList;

import java.util.ArrayList;

/**
 * Created by Ilya on 27.06.2018.
 */

public class UserItemPresenter {
    private UserItemModel userItemModel;
    private UserItem userItem;

    public UserItemPresenter(UserItem userItem, Person person) {
        this.userItem = userItem;

        userItemModel = new UserItemModel(person);
    }

    public void savePerson(Person person) {
        userItemModel.savePerson(person);
        userItem.representPerson(person.login);
        userItem.setSubscribeButton(person.isYouFollowed);
    }

    public void subscribeButtonClicked() {
        boolean youFollowed;
        youFollowed = userItemModel.getPerson().isYouFollowed;

        if (youFollowed)
            userItemModel.unsubscribe();
        else
            userItemModel.subscribe();

        userItem.setSubscribeButton(!youFollowed);
    }

    public int getUserId() {
        return userItemModel.getPerson().userId;
    }
}
