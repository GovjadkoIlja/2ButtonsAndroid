package com.example.ilya.ourfuture.UsersList;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ilya.ourfuture.Shared.ErrorFragment;
import com.example.ilya.ourfuture.R;

import java.util.ArrayList;

public abstract class UsersListFragment extends ListFragment {

    public UsersListPresenter usersListPresenter;

    public void representUsersList(ArrayList<Person> people) {
        if (getActivity() == null) {
            System.out.println("CATCHED!");
            return;
        }

        UsersListAdapter usersListAdapter = new UsersListAdapter(getActivity(), R.layout.fragment_user_item, R.layout.fragment_user_item, people, this);
        setListAdapter(usersListAdapter);
    }

    public void errorOccured(int errorType) {

        Bundle errorArgs = new Bundle();

        errorArgs.putInt("errorType", errorType);

        Fragment errorFragment = new ErrorFragment();
        errorFragment.setArguments(errorArgs);
        FragmentTransaction markersOwnHeaderFt = getFragmentManager().beginTransaction();
        markersOwnHeaderFt.add(this.getId(), errorFragment);
        markersOwnHeaderFt.commit();
    }

}
