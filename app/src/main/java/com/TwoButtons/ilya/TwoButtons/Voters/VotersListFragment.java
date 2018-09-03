package com.TwoButtons.ilya.TwoButtons.Voters;


import android.os.Bundle;
import android.app.Fragment;

import com.TwoButtons.ilya.TwoButtons.UsersList.UsersListFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class VotersListFragment extends UsersListFragment {

    int questionId;
    int option;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();

        questionId = args.getInt("questionId", 0);
        option = args.getInt("option", 1);

        usersListPresenter = new VotersListPresenter(this);

        receiveVoters(option, "");
    }

    public void receiveVoters(int option, String searchText) {
        if (usersListAdapter != null) {
            usersListAdapter.clear();
            usersListAdapter.notifyDataSetChanged();
        }
        ((VotersListPresenter)usersListPresenter).receiveVoters(questionId, option, searchText);
    }

    public void receiveVoters(int option) {
        if (usersListAdapter != null) {
            System.out.println("CLEAR!");
            usersListAdapter.clear();
            usersListAdapter.notifyDataSetChanged();
        }
        ((VotersListPresenter)usersListPresenter).receiveVoters(questionId, option);
    }

    @Override
    public void searchTextChanged(String searchText) {
        ((VotersListPresenter)usersListPresenter).receiveVoters(questionId, option, searchText);
    }
}
