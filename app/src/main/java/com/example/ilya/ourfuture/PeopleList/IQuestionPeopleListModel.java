package com.example.ilya.ourfuture.PeopleList;

import java.util.List;

/**
 * Created by Ilya on 16.02.2018.
 */

public interface IQuestionPeopleListModel {
    void receiveAnsweredPeopleList(int id, int questionId, int option, int minAge, int maxAge, int sex, String search);
    List<ShortUser> getAnsweredList(int option);
}
