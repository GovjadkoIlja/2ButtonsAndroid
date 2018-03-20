package com.example.ilya.ourfuture.QuestionPage;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.FooterFragment;
import com.example.ilya.ourfuture.Shared.HeaderFragment;

public class QuestionActivity extends AppCompatActivity {

    final String header = "Вопрос";
    boolean showBack = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);

        Bundle headerArgs = new Bundle();
        headerArgs.putString("headerText", header);
        headerArgs.putBoolean("showBack", showBack);

        Fragment headerFragment = new HeaderFragment();
        headerFragment.setArguments(headerArgs);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.questionFrameHeader, headerFragment);
        ft.commit();

        Bundle questionHeaderArgs = new Bundle();
        questionHeaderArgs.putInt("id", id);

        Fragment questionHeaderFragment = new QuestionHeaderFragment();
        questionHeaderFragment.setArguments(questionHeaderArgs);
        FragmentTransaction questionHeaderFt = getFragmentManager().beginTransaction();
        questionHeaderFt.add(R.id.questionOwnFrameHeader, questionHeaderFragment);
        questionHeaderFt.commit();

        Bundle questionMainArgs = new Bundle();
        questionMainArgs.putInt("id", id);

        Fragment questionMainFragment = new QuestionMainFragment();
        questionMainFragment.setArguments(questionMainArgs);
        FragmentTransaction questionMainFt = getFragmentManager().beginTransaction();
        questionMainFt.add(R.id.questionFrameMain, questionMainFragment);
        questionMainFt.commit();

        Bundle footerArgs = new Bundle();

        footerArgs.putInt("id", id);

        Fragment questionFooterFragment = new FooterFragment();
        questionFooterFragment.setArguments(footerArgs);
        FragmentTransaction questionFooterFt = getFragmentManager().beginTransaction();
        questionFooterFt.add(R.id.questionFrameFooter, questionFooterFragment);
        questionFooterFt.commit();

    }
}