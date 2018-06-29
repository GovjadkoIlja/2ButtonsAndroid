package com.example.ilya.ourfuture.PeopleList;

import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.UsersList.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilya on 16.01.2018.
 */

public class PeopleListPresenter implements IPeopleListPresenter {

    IPeopleListView peopleListView;
    IPeopleListModel peopleListModel;

    IQuestionPeopleListModel questionPeopleListModel;

    final int defaultMinAge = 0;
    final int defaultMaxAge = 100;
    final int defaultSex = 0;
    final String defaultSearch = "";

    PeopleListPresenter(IPeopleListView _peopleListView) {
        peopleListView = _peopleListView;
        questionPeopleListModel = new QuestionPeopleListModel(this);
    }

    PeopleListPresenter(int userId, IPeopleListView _peopleListView) {
        peopleListView = _peopleListView;
        peopleListModel = new PeopleListModel(userId, this);
    }

    @Override
    public void receivePeopleList(boolean isFollowers, boolean isFollowTo) {
        peopleListModel.receivePeopleList(isFollowers, isFollowTo);
    }

    @Override
    public void peopleGot(List<ShortUser> people) {

    }

    /*public void peopleGot(ArrayList<Person> people) {
        peopleListView.representPeopleList(people);
    }*/

    @Override
    public String getAgeSexText(int age, int sex) {
        String sexText;
        if (sex == 1)
            sexText = "М";
        else
            sexText = "Ж";

        return age + " лет, " + sexText;
    }

    @Override
    public void userSelected(int userId) {
        peopleListView.openUserPage(Id.getId(), userId);
    }

    @Override
    public void getVoters(int questionId, int option) {
        questionPeopleListModel.receiveAnsweredPeopleList(Id.getId(), questionId, option, defaultMinAge, defaultMaxAge, defaultSex, defaultSearch);
    }

    @Override
    public void questionOptionChanged(int option) {
        List<ShortUser> people = questionPeopleListModel.getAnsweredList(option);
        peopleListView.representPeopleList(people);
    }
}
