package com.example.ilya.ourfuture.UserPage;

/**
 * Created by Ilya on 16.01.2018.
 */

public class UserButtonsModel implements IUserButtonsModel {

    int userId;

    public UserButtonsModel(int _userId) {
        userId = _userId;
    }

    /*@Override
    public void setData(int id, int userId) {
        id = id;
        userId = userId;
    }*/

    /*@Override
    public int getId() {
        return id;
    }*/

    @Override
    public int getUserId() {
        return userId;
    }
}
