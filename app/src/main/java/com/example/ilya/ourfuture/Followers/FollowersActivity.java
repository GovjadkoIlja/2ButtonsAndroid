package com.example.ilya.ourfuture.Followers;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.example.ilya.ourfuture.UsersList.UserListSearchFragment;
import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.FooterFragment;
import com.example.ilya.ourfuture.Shared.HeaderFragment;

public class FollowersActivity extends Activity {

    final String headerFollowers = "Подписчики";
    final String headerFollowTo = "Подписки";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);

        Intent intent = getIntent();
        int userId  = intent.getIntExtra("userId", 0);
        int listType = intent.getIntExtra("listType", 1);

        Bundle headerArgs = new Bundle();

        headerArgs.putString("headerText", listType == 1 ? headerFollowers : headerFollowTo);

        Fragment headerFragment = new HeaderFragment();
        headerFragment.setArguments(headerArgs);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.followersFrameHeader, headerFragment);
        ft.commit();

        Fragment searchFragment = new UserListSearchFragment();
        FragmentTransaction searchTransaction = getFragmentManager().beginTransaction();
        searchTransaction.add(R.id.followersFrameSearch, searchFragment);
        searchTransaction.commit();

        Bundle peopleListArgs = new Bundle();

        //peopleListArgs.putInt("id", id);
        peopleListArgs.putInt("userId", userId);
        peopleListArgs.putInt("listType", listType);

        Fragment peopleListFragment = new FollowersFragment();
        peopleListFragment.setArguments(peopleListArgs);
        FragmentTransaction peopleListTransaction = getFragmentManager().beginTransaction();
        peopleListTransaction.add(R.id.followersFramePeople, peopleListFragment);
        peopleListTransaction.commit();

        /*Bundle footerArgs = new Bundle();

        footerArgs.putInt("id", id);*/

        Fragment peopleListFooterFragment = new FooterFragment();
        //peopleListFooterFragment.setArguments(footerArgs);
        FragmentTransaction peopleListFooterFt = getFragmentManager().beginTransaction();
        peopleListFooterFt.add(R.id.followersFrameFooter, peopleListFooterFragment);
        peopleListFooterFt.commit();
    }
}
