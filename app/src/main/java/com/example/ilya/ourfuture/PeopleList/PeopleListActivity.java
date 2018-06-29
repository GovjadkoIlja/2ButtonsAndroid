package com.example.ilya.ourfuture.PeopleList;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.FooterFragment;
import com.example.ilya.ourfuture.Shared.HeaderFragment;
import com.example.ilya.ourfuture.UsersList.UserListSearchFragment;

public class PeopleListActivity extends Activity {

    String headerFollowers = "Подписчики";
    String headerFollowTo = "Подписки";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_list);

        System.out.println("AAAA");

        Intent intent = getIntent();
        //int id = intent.getIntExtra("id", 0);
        int userId  = intent.getIntExtra("userId", 0);
        boolean isFollowers = intent.getBooleanExtra("isFollowers", false);
        boolean isFollowTo = intent.getBooleanExtra("isFollowTo", false);

        Bundle headerArgs = new Bundle();

        if (isFollowers)
            headerArgs.putString("headerText", headerFollowers);
        else if (isFollowTo)
            headerArgs.putString("headerText", headerFollowTo);


        Fragment headerFragment = new HeaderFragment();
        headerFragment.setArguments(headerArgs);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.peopleListFrameHeader, headerFragment);
        ft.commit();

        Fragment searchFragment = new UserListSearchFragment();
        FragmentTransaction searchTransaction = getFragmentManager().beginTransaction();
        searchTransaction.add(R.id.peopleListFrameSearch, searchFragment);
        searchTransaction.commit();

        Bundle peopleListArgs = new Bundle();

        //peopleListArgs.putInt("id", id);
        peopleListArgs.putInt("userId", userId);
        peopleListArgs.putBoolean("isFollowers", isFollowers);
        peopleListArgs.putBoolean("isFollowTo", isFollowTo);

        Fragment peopleListFragment = new PeopleListFragment();
        peopleListFragment.setArguments(peopleListArgs);
        FragmentTransaction peopleListTransaction = getFragmentManager().beginTransaction();
        peopleListTransaction.add(R.id.peopleListFramePeople, peopleListFragment);
        peopleListTransaction.commit();

        /*Bundle footerArgs = new Bundle();

        footerArgs.putInt("id", id);*/

        Fragment peopleListFooterFragment = new FooterFragment();
        //peopleListFooterFragment.setArguments(footerArgs);
        FragmentTransaction peopleListFooterFt = getFragmentManager().beginTransaction();
        peopleListFooterFt.add(R.id.peopleListFrameFooter, peopleListFooterFragment);
        peopleListFooterFt.commit();
    }
}
