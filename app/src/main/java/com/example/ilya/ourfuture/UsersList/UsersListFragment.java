package com.example.ilya.ourfuture.UsersList;

import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ilya.ourfuture.PeopleList.IPeopleListPresenter;
import com.example.ilya.ourfuture.PeopleList.IPeopleListView;
import com.example.ilya.ourfuture.PeopleList.PeopleListPresenter;
import com.example.ilya.ourfuture.PeopleList.ShortUser;
import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.UserPage.UserActivity;

import java.util.ArrayList;
import java.util.List;

public abstract class UsersListFragment extends ListFragment {

    public UsersListPresenter usersListPresenter;
    public boolean showAgeSex;

    public void representUsersList(ArrayList<Person> people) {
        UsersListAdapter usersListAdapter = new UsersListAdapter(getActivity(), R.layout.fragment_user_item, R.layout.fragment_user_item, people, this, showAgeSex);
        setListAdapter(usersListAdapter);
    }

}
