package com.example.ilya.ourfuture.UsersList;

import com.example.ilya.ourfuture.Shared.ServerConnection;

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
        userItem.setPhoto(person.smallAvatarLink);
        userItem.setSubscribeButton(person.userId, person.isYouFollowed);
    }

    public void subscribeButtonClicked() {
        boolean youFollowed;
        youFollowed = userItemModel.getPerson().isYouFollowed;

        if (youFollowed)
            userItemModel.unsubscribe();
        else
            userItemModel.subscribe();

        userItem.setSubscribeButton(userItemModel.getPerson().userId, !youFollowed);
    }

    public int getUserId() {
        return userItemModel.getPerson().userId;
    }

    public String getUserLogin() {
        return userItemModel.getPerson().login;
    }
}
