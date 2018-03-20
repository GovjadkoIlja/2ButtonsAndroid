package com.example.ilya.ourfuture.PeopleList;

import java.util.List;

/**
 * Created by Ilya on 16.01.2018.
 */

public interface IPeopleListPresenter {
    void receivePeopleList(boolean isFollowers, boolean isFollowTo);
    void peopleGot(List<ShortUser> people);
    String getAgeSexText(int age, int sex);
    void userSelected(int userId);

    void getVoters(int questionId, int option);
    void questionOptionChanged(int option);
}
