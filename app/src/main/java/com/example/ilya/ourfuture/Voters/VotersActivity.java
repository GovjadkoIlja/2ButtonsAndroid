package com.example.ilya.ourfuture.Voters;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.ErrorFragment;
import com.example.ilya.ourfuture.Shared.FooterFragment;
import com.example.ilya.ourfuture.Shared.HeaderFragment;
import com.example.ilya.ourfuture.Tops.TopQuestionsFragment;

import java.util.ArrayList;

public class VotersActivity extends Activity implements VotersMenuFragment.SelectedOptions {

    final String headerString = "Ответы";
    int questionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voters);

        Intent intent = getIntent();
        int questionId  = intent.getIntExtra("questionId", 1);
        String condition = intent.getStringExtra("condition");
        int option = intent.getIntExtra("option", 1);
        ArrayList<String> options = intent.getStringArrayListExtra("options");

        this.questionId = questionId;

        Bundle headerArgs = new Bundle();

        headerArgs.putString("headerText", headerString);

        Fragment headerFragment = new HeaderFragment();
        headerFragment.setArguments(headerArgs);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.votersFrameHeader, headerFragment);
        ft.commit();

        Bundle conditionArgs = new Bundle();

        conditionArgs.putString("condition", condition);

        Fragment conditionFragment = new VotersConditionFragment();
        conditionFragment.setArguments(conditionArgs);
        FragmentTransaction conditionTransaction = getFragmentManager().beginTransaction();
        conditionTransaction.add(R.id.votersFrameCondition, conditionFragment);
        conditionTransaction.commit();

        Bundle optionsArgs = new Bundle();

        optionsArgs.putStringArrayList("options", options);
        optionsArgs.putInt("option", option);

        Fragment optionsFragment = new VotersMenuFragment();
        optionsFragment.setArguments(optionsArgs);
        FragmentTransaction optionsTransaction = getFragmentManager().beginTransaction();
        optionsTransaction.add(R.id.votersFrameMenu, optionsFragment);
        optionsTransaction.commit();

        Bundle votersListArgs = new Bundle();

        //votersListArgs.putInt("id", id);
        votersListArgs.putInt("questionId", questionId);
        votersListArgs.putInt("option", option);

        Fragment votersListFragment = new VotersListFragment();
        votersListFragment.setArguments(votersListArgs);
        FragmentTransaction peopleListTransaction = getFragmentManager().beginTransaction();
        peopleListTransaction.add(R.id.votersFramePeople, votersListFragment);
        peopleListTransaction.commit();

        Fragment votersListFooterFragment = new FooterFragment();
        //votersListFooterFragment.setArguments(footerArgs);
        FragmentTransaction peopleListFooterFt = getFragmentManager().beginTransaction();
        peopleListFooterFt.add(R.id.votersFrameFooter, votersListFooterFragment);
        peopleListFooterFt.commit();
    }

    @Override
    public void selectedOptionChanged(int selected) {
        FragmentManager fragmentManager = getFragmentManager();

        VotersListFragment fragmentPeopleList;

        boolean isFromErrorFragment = fragmentManager
                .findFragmentById(R.id.votersFramePeople).getClass() == ErrorFragment.class;

        if (!isFromErrorFragment) {
            fragmentPeopleList = (VotersListFragment) fragmentManager
                    .findFragmentById(R.id.votersFramePeople);
            fragmentPeopleList.receiveVoters(selected);
        } else {
            System.out.println("AAAAAAAAAAAA");
            ErrorFragment errorFragment = (ErrorFragment) fragmentManager
                    .findFragmentById(R.id.votersFramePeople);

            getFragmentManager().beginTransaction().remove(errorFragment).commit();

            Bundle votersListArgs = new Bundle();

            //votersListArgs.putInt("id", id);
            votersListArgs.putInt("questionId", questionId);
            votersListArgs.putInt("option", selected);

            fragmentPeopleList = new VotersListFragment();
            fragmentPeopleList.setArguments(votersListArgs);
            FragmentTransaction questionsTransaction = getFragmentManager().beginTransaction();
            questionsTransaction.replace(R.id.votersFramePeople, fragmentPeopleList);
            questionsTransaction.commit();
        }

        /*if (fragmentPeopleList != null) {

            fragmentPeopleList.receiveVoters(selected);
        }*/

    }
}
