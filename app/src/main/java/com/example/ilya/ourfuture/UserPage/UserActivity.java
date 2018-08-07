package com.example.ilya.ourfuture.UserPage;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;

import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.ErrorFragment;
import com.example.ilya.ourfuture.Shared.FooterFragment;
import com.example.ilya.ourfuture.Shared.HeaderFragment;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.MenuFourFragment;
import com.example.ilya.ourfuture.Tops.TopQuestionsFragment;

import java.util.ArrayList;

public class UserActivity extends Activity implements MenuFourFragment.OnSelectedListListener, UserInfoFragment.UserInfoGot {

    //final String header = "Моя страница";
    boolean showBack = true;
    int userId;

    final String[] menu = {"Вопросы", "Ответы", "Избранное", "Комментарии"};
    /*Добавить в хедер кнопку уведомлений*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Intent intent = getIntent();
        //int id = intent.getIntExtra("id", 0);
        int userId  = intent.getIntExtra("userId", Id.getId());
        String header = intent.getStringExtra("userLogin");
        boolean fromRegistration = intent.getBooleanExtra("fromRegistration", false);

        this.userId = userId;

        showBack = !fromRegistration;

        Bundle headerArgs = new Bundle();
        headerArgs.putString("headerText", header);
        headerArgs.putBoolean("showBack", showBack);

        Fragment headerFragment = new HeaderFragment();
        headerFragment.setArguments(headerArgs);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.userFrameHeader, headerFragment);
        ft.commit();

        Fragment userPhotoFragment = new UserPhotoFragment();
        FragmentTransaction userPhotoFt = getFragmentManager().beginTransaction();
        userPhotoFt.add(R.id.userFrameUserPhoto, userPhotoFragment);
        userPhotoFt.commit();

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

        ArrayList<String> menuStrings = fillMenuArray(menu);

        Bundle menuArgs = new Bundle();
        menuArgs.putStringArrayList("menuStrings", menuStrings);

        Fragment markersHeaderFragment = new MenuFourFragment();
        markersHeaderFragment.setArguments(menuArgs);
        FragmentTransaction markersOwnHeaderFt = getFragmentManager().beginTransaction();
        markersOwnHeaderFt.add(R.id.userFrameMenuFour, markersHeaderFragment);
        markersOwnHeaderFt.commit();

        ListFragment userPostsFragment = new UsersQuestionsFragment();
        userPostsFragment.setArguments(userPageArgs);
        FragmentTransaction userPoistsFt = getFragmentManager().beginTransaction();
        userPoistsFt.add(R.id.userFramePosts, userPostsFragment);
        userPoistsFt.commit();

        Fragment userFooterFragment = new FooterFragment();
        FragmentTransaction userFooterFt = getFragmentManager().beginTransaction();
        userFooterFt.add(R.id.userFrameFooter, userFooterFragment);
        userFooterFt.commit();
    }

    @Override
    public void onListSelected(int type) {
        FragmentManager fragmentManager = getFragmentManager();

        UsersQuestionsFragment fragmentQuestions;

        boolean isFromErrorFragment = fragmentManager
                .findFragmentById(R.id.userFramePosts).getClass() == ErrorFragment.class;

        if (!isFromErrorFragment) {
            fragmentQuestions = (UsersQuestionsFragment) fragmentManager
                    .findFragmentById(R.id.userFramePosts);
        } else {
            ErrorFragment errorFragment = (ErrorFragment) fragmentManager
                    .findFragmentById(R.id.userFramePosts);

            getFragmentManager().beginTransaction().remove(errorFragment).commit();

            Bundle userPageArgs = new Bundle();
            userPageArgs.putInt("userId", userId);

            fragmentQuestions = new UsersQuestionsFragment();
            fragmentQuestions.setArguments(userPageArgs);
            FragmentTransaction questionsTransaction = getFragmentManager().beginTransaction();
            questionsTransaction.add(R.id.userFramePosts, fragmentQuestions);
            questionsTransaction.commit();
        }

        System.out.println(isFromErrorFragment + "QQQQ");

        if (fragmentQuestions != null) {
            System.out.println("AAAAAAA " + type);
            fragmentQuestions.questionsTypeChanged(type, isFromErrorFragment, userId);
        }
    }

    private ArrayList<String> fillMenuArray(String[] menu) {
        ArrayList<String> menuStrings = new ArrayList<>();

        for (int i = 0; i < menu.length; i++)
            menuStrings.add(menu[i]);

        return menuStrings;
    }

    @Override
    public void userInfoGot(UserInfo user) {
        UserButtonsFragment userButtonsFragment = (UserButtonsFragment) getFragmentManager()
                .findFragmentById(R.id.userFrameUserButtons);
        userButtonsFragment.setButtonsValues(user);

        UserPhotoFragment userPhotoFragment = (UserPhotoFragment) getFragmentManager()
                .findFragmentById(R.id.userFrameUserPhoto);
        userPhotoFragment.setPhoto(user.largeAvatarUrl);
    }
}
