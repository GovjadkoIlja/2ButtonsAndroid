package com.example.ilya.ourfuture.Followers;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ilya.ourfuture.PeopleList.PeopleListFragment;
import com.example.ilya.ourfuture.PeopleList.PeopleListPresenter;
import com.example.ilya.ourfuture.PeopleList.ShortUser;
import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.UsersList.Person;
import com.example.ilya.ourfuture.UsersList.UsersListFragment;
import com.example.ilya.ourfuture.UsersList.UsersListPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FollowersFragment extends UsersListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showAgeSex = false;

        Bundle args = getArguments();

        int userId = args.getInt("userId", Id.getId());
        int listType = args.getInt("listType", 1);

        usersListPresenter = new FollowersPresenter(this, userId);

        ((FollowersPresenter)usersListPresenter).receiveUsersList(listType);
    }

}
