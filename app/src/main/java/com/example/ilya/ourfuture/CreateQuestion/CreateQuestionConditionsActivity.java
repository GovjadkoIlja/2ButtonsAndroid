package com.example.ilya.ourfuture.CreateQuestion;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.HeaderFragment;

import java.util.ArrayList;

public class CreateQuestionConditionsActivity extends FragmentActivity implements CreateQuestionFurtherFragment.ButtonFurtherClicked {

    final String headerText = "Задать вопрос";
    final String headerHelpText = "1/3";

    final String conditionHeader = "Вопрос";
    final String conditionDefault = "Введите условие вопроса";
    final int conditionMaxLength = 150;

    final String buttonText = "Далее";
    final boolean showFurther = true;

    final String firstOptionHeader = "Вариант 1";
    final String firstOptionDefault = "Введите первый вариант";
    final int optionMaxLength = 100;

    final String secondOptionHeader = "Вариант 2";
    final String secondOptionDefault = "Введите второй вариант";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_question);

        Bundle headerArgs = new Bundle();

        headerArgs.putString("headerText", headerText);
        headerArgs.putString("headerHelpText", headerHelpText);

        Fragment headerFragment = new HeaderFragment();
        headerFragment.setArguments(headerArgs);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.createQuestionFrameHeader, headerFragment);
        ft.commit();

        Fragment createQuestionConditionFragment = new CreateQuestionConditionFragment();
        FragmentTransaction createQuestionConditionTransaction = getFragmentManager().beginTransaction();
        createQuestionConditionTransaction.add(R.id.createQuestionFrameCondition, createQuestionConditionFragment);
        createQuestionConditionTransaction.commit();

        Bundle furtherArgs = new Bundle();

        furtherArgs.putString("buttonText", buttonText);
        furtherArgs.putBoolean("showFurther", showFurther);

        Fragment createQuestionFurtherFragment = new CreateQuestionFurtherFragment();
        createQuestionFurtherFragment.setArguments(furtherArgs);
        FragmentTransaction createQuestionFurtherTransaction = getFragmentManager().beginTransaction();
        createQuestionFurtherTransaction.add(R.id.createQuestionFrameFurther, createQuestionFurtherFragment);
        createQuestionFurtherTransaction.commit();
    }

    public String getCondition() {
        CreateQuestionConditionFragment fragment = (CreateQuestionConditionFragment) getFragmentManager()
                .findFragmentById(R.id.createQuestionFrameCondition);

        return fragment.getCondition();
    }

    public ArrayList<String> getOptions() {
        CreateQuestionConditionFragment fragment = (CreateQuestionConditionFragment) getFragmentManager()
                .findFragmentById(R.id.createQuestionFrameCondition);

        return fragment.getOptions();
    }


    @Override
    public void further() {
        String condition = getCondition();
        ArrayList<String> options = getOptions();

        Intent intent = new Intent(this, CreateQuestionSettingsActivity.class);

        intent.putExtra("condition", condition);
        intent.putExtra("options", options);

        startActivity(intent);
    }
}
