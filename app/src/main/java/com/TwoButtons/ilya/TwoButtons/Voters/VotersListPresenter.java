package com.TwoButtons.ilya.TwoButtons.Voters;

import com.TwoButtons.ilya.TwoButtons.UsersList.UsersListPresenter;

/**
 * Created by Ilya on 30.06.2018.
 */

public class VotersListPresenter extends UsersListPresenter {

    public VotersListPresenter(VotersListFragment votersListFragment) {
        usersListFragment = votersListFragment;
        usersListModel = new VotersListModel(this);
    }

    public void receiveVoters(int questionId, int option, String searchText) {
        ((VotersListModel)usersListModel).getVoters(questionId, option, searchText);
    }

    public void receiveVoters(int questionId, int option) {
        ((VotersListModel)usersListModel).getVoters(questionId, option, ((VotersListModel) usersListModel).getSearchText());
    }
}
