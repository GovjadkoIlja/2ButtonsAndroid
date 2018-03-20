package com.example.ilya.ourfuture.PeopleList;

/**
 * Created by Ilya on 16.01.2018.
 */

public class PeopleSearchPresenter implements IPeopleSearchPresenter {

    IPeopleSearchView peopleSearchView;

    PeopleSearchPresenter(IPeopleSearchView _peopleSearchView) {
        peopleSearchView = _peopleSearchView;
    }

    @Override
    public void searchTextChanged(String searchText) {
        peopleSearchView.changeEraseButtonVisibility(searchText.length() > 0);
    }


}
