package com.example.ilya.ourfuture.Voters;


import android.os.Bundle;
import android.app.Fragment;

import com.example.ilya.ourfuture.UsersList.UsersListFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class VotersListFragment extends UsersListFragment {

    int questionId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();

        questionId = args.getInt("questionId", 0);
        int option = args.getInt("option", 1);

        usersListPresenter = new VotersListPresenter(this);

        receiveVoters(option);
    }

    public void receiveVoters(int option) {
        ((VotersListPresenter)usersListPresenter).receiveVoters(questionId, option);
    }

}
