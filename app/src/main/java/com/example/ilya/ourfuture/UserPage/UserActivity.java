package com.example.ilya.ourfuture.UserPage;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.FooterFragment;
import com.example.ilya.ourfuture.Shared.HeaderFragment;
import com.example.ilya.ourfuture.Shared.Id;

public class UserActivity extends Activity {

    final String header = "Моя страница";
    boolean showBack = true;

    /*Добавить в хедер кнопку уведомлений*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Intent intent = getIntent();
        //int id = intent.getIntExtra("id", 0);
        int userId  = intent.getIntExtra("userId", Id.getId());
        boolean fromRegistration = intent.getBooleanExtra("fromRegistration", false);

        showBack = !fromRegistration;

        Bundle headerArgs = new Bundle();
        headerArgs.putString("headerText", header);
        headerArgs.putBoolean("showBack", showBack);

        Fragment headerFragment = new HeaderFragment();
        headerFragment.setArguments(headerArgs);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.userFrameHeader, headerFragment);
        ft.commit();

        Bundle userPageArgs = new Bundle();
        userPageArgs.putInt("userId", userId);

        Fragment userInfoFragment = new UserInfoFragment();
        userInfoFragment.setArguments(userPageArgs);
        FragmentTransaction userInfoFt = getFragmentManager().beginTransaction();
        userInfoFt.add(R.id.userFrameUserInfo, userInfoFragment);
        userInfoFt.commit();

        Fragment userButtonsFragment = new UserButtonsFragment();
        userButtonsFragment.setArguments(userPageArgs);
        FragmentTransaction userButtonsFt = getFragmentManager().beginTransaction();
        userButtonsFt.add(R.id.userFrameUserButtons, userButtonsFragment);
        userButtonsFt.commit();

        Fragment userPostsFragment = new PostsFragment();
        userPostsFragment.setArguments(userPageArgs);
        FragmentTransaction userPoistsFt = getFragmentManager().beginTransaction();
        userPoistsFt.add(R.id.userFramePosts, userPostsFragment);
        userPoistsFt.commit();

        Fragment userFooterFragment = new FooterFragment();
        FragmentTransaction userFooterFt = getFragmentManager().beginTransaction();
        userFooterFt.add(R.id.userFrameFooter, userFooterFragment);
        userFooterFt.commit();
    }
}
