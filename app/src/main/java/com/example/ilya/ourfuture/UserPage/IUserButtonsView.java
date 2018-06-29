package com.example.ilya.ourfuture.UserPage;

/**
 * Created by Ilya on 16.01.2018.
 */

public interface IUserButtonsView {
    void getPeopleList(int userId, int listType);
    void setButtonFollow(boolean isYoursPage, boolean isFollowed);
}
