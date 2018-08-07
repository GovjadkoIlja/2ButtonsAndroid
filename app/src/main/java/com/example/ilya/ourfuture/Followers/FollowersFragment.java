package com.example.ilya.ourfuture.Followers;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.UsersList.UsersListFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class FollowersFragment extends UsersListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();

        int userId = args.getInt("userId", Id.getId());
        int listType = args.getInt("listType", 1);

        usersListPresenter = new FollowersPresenter(this, userId);

        ((FollowersPresenter)usersListPresenter).receiveUsersList(listType);
    }

}
