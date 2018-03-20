package com.example.ilya.ourfuture.UserPage;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.ilya.ourfuture.PeopleList.PeopleListActivity;
import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.Id;

public class UserButtonsFragment extends Fragment implements IUserButtonsView, View.OnClickListener {

    IUserButtonsPresenter userButtonsPresenter;

    LinearLayout llFollowers;
    LinearLayout llFollowTo;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user_buttons, container, false);

        Bundle args = getArguments();

        //int id = args.getInt("id");
        int userId = args.getInt("userId", Id.getId());

        userButtonsPresenter = new UserButtonsPresenter(userId, this);

        llFollowers = view.findViewById(R.id.llUserFollowers);
        llFollowTo = view.findViewById(R.id.llUserFollowTo);
        llFollowers.setOnClickListener(this);
        llFollowTo.setOnClickListener(this);

        return view;
    }

    @Override
    public void getPeopleList(int userId, boolean isFollowers, boolean isFollowTo) {
        Intent intent = new Intent(this.getActivity(), PeopleListActivity.class);
        //intent.putExtra("id", id);
        intent.putExtra("userId", userId);
        intent.putExtra("isFollowers", isFollowers);
        intent.putExtra("isFollowTo", isFollowTo);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {

        int clickedLayout = 0;

        switch (view.getId()) {
            case (R.id.llUserFollowers):
                clickedLayout = 1;
                break;
            case (R.id.llUserFollowTo):
                clickedLayout = 2;
                break;
        }

        userButtonsPresenter.layoutClicked(clickedLayout);
    }
}
