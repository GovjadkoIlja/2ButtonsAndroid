package com.example.ilya.ourfuture.QuestionPage;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.example.ilya.ourfuture.PeopleList.PeopleListFragment;
import com.example.ilya.ourfuture.UsersList.UserListSearchFragment;
import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.FooterFragment;
import com.example.ilya.ourfuture.Shared.HeaderFragment;

public class QuestionPeopleListActivity extends Activity implements QuestionPeopleListHeaderFragment.OnSelectedOptionListener {

    final String header = "Ответившие";
    final boolean fromRegistration = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_people_list);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        int questionId  = intent.getIntExtra("questionId", 0);
        int option  = intent.getIntExtra("option", 1);
        String firstOption = intent.getStringExtra("firstOption");
        String secondOption = intent.getStringExtra("secondOption");

        Bundle headerArgs = new Bundle();
        headerArgs.putString("headerText", header);
        headerArgs.putBoolean("showBack", !fromRegistration);

        Fragment headerFragment = new HeaderFragment();
        headerFragment.setArguments(headerArgs);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.questionPeopleListFrameHeader, headerFragment);
        ft.commit();

        Bundle peopleListHeaderArgs = new Bundle();
        peopleListHeaderArgs.putInt("option", option);
        peopleListHeaderArgs.putString("firstOption", firstOption);
        peopleListHeaderArgs.putString("secondOption", secondOption);

        Fragment peopleListHeaderFragment = new QuestionPeopleListHeaderFragment();
        peopleListHeaderFragment.setArguments(peopleListHeaderArgs);
        FragmentTransaction peopleListHeaderTransaction = getFragmentManager().beginTransaction();
        peopleListHeaderTransaction.add(R.id.questionPeopleListFrameOwnHeader, peopleListHeaderFragment);
        peopleListHeaderTransaction.commit();

        Fragment searchFragment = new UserListSearchFragment();
        FragmentTransaction searchTransaction = getFragmentManager().beginTransaction();
        searchTransaction.add(R.id.peopleListFrameSearch, searchFragment);
        searchTransaction.commit();

        Bundle peopleListArgs = new Bundle();

        peopleListArgs.putInt("id", id);
        peopleListArgs.putInt("questionId", questionId);
        peopleListArgs.putInt("option", option);

        Fragment peopleListFragment = new PeopleListFragment();
        peopleListFragment.setArguments(peopleListArgs);
        FragmentTransaction peopleListTransaction = getFragmentManager().beginTransaction();
        peopleListTransaction.add(R.id.peopleListFramePeople, peopleListFragment);
        peopleListTransaction.commit();

        Bundle footerArgs = new Bundle();

        footerArgs.putInt("id", id);

        Fragment footerFragment = new FooterFragment();
        footerFragment.setArguments(footerArgs);
        FragmentTransaction footerFt = getFragmentManager().beginTransaction();
        footerFt.add(R.id.questionPeopleListFrameFooter, footerFragment);
        footerFt.commit();

    }

    @Override
    public void onOptionSelected(int option) {
        FragmentManager fragmentManager = getFragmentManager();

        PeopleListFragment fragmentPeopleList = (PeopleListFragment) fragmentManager
                .findFragmentById(R.id.peopleListFramePeople);

        if (fragmentPeopleList != null)
            fragmentPeopleList.questionOptionChanged(option);

    }
}
