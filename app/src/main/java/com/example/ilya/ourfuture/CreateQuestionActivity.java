package com.example.ilya.ourfuture;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.ilya.ourfuture.Shared.HeaderFragment;

public class CreateQuestionActivity extends Activity {

    final String headerText = "Задать вопрос";
    final String headerHelpText = "1/3";

    final String conditionHeader = "Вопрос";
    final String conditionDefault = "Введите условие вопроса";
    final int conditionMaxLength = 150;

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

        Bundle conditionArgs = new Bundle();

        conditionArgs.putString("header", conditionHeader);
        conditionArgs.putInt("maxLength", conditionMaxLength);
        conditionArgs.putString("defaultText", conditionDefault);

        Fragment conditionFragment = new HeaderFragment();
        conditionFragment.setArguments(conditionArgs);
        FragmentTransaction conditionTransaction = getFragmentManager().beginTransaction();
        conditionTransaction.add(R.id.createQuestionFrameCondition, conditionFragment);
        conditionTransaction.commit();

        Bundle firstOptionArgs = new Bundle();

        firstOptionArgs.putString("header", firstOptionHeader);
        firstOptionArgs.putInt("maxLength", optionMaxLength);
        firstOptionArgs.putString("defaultText", firstOptionDefault);

        Fragment firstOptionFragment = new HeaderFragment();
        firstOptionFragment.setArguments(firstOptionArgs);
        FragmentTransaction firstOptionTransaction = getFragmentManager().beginTransaction();
        firstOptionTransaction.add(R.id.createQuestionFrameFirstOption, firstOptionFragment);
        firstOptionTransaction.commit();
    }
}
