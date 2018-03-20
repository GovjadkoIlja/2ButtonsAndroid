package com.example.ilya.ourfuture.PeopleList;

import java.util.List;

/**
 * Created by Ilya on 16.01.2018.
 */

public interface IPeopleListView {
    void representPeopleList(List<ShortUser> people);
    void openUserPage(int id, int userId);
}
