package com.example.ilya.ourfuture.CreateQuestion;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.HeaderFragment;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.example.ilya.ourfuture.UserPage.UserActivity;

import java.util.ArrayList;

public class CreateQuestionSettingsActivity extends Activity implements CreateQuestionFurtherFragment.ButtonFurtherClicked {

    final String headerText = "Задать вопрос";
    final String headerHelpText = "3/3";

    final String buttonText = "Опубликовать";
    final boolean showFurther = false;

    String condition;
    ArrayList<String> options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_question_settings);

        System.out.println("AAAAAAA");

        Bundle headerArgs = new Bundle();

        headerArgs.putString("headerText", headerText);
        headerArgs.putString("headerHelpText", headerHelpText);

        Fragment headerFragment = new HeaderFragment();
        headerFragment.setArguments(headerArgs);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.createQuestionSettingsFrameHeader, headerFragment);
        ft.commit();

        Intent intent = getIntent();
        condition = intent.getStringExtra("condition");
        options = intent.getStringArrayListExtra("options");

        System.out.println();;

        Bundle exampleArgs = new Bundle();
        exampleArgs.putString("condition", condition);
        exampleArgs.putStringArrayList("options", options);

        Fragment createQuestionExampleFragment = new CreateQuestionExampleFragment();
        createQuestionExampleFragment.setArguments(exampleArgs);
        FragmentTransaction createQuestionExampleTransaction = getFragmentManager().beginTransaction();
        createQuestionExampleTransaction.add(R.id.createQuestionSettingsFrameExample, createQuestionExampleFragment);
        createQuestionExampleTransaction.commit();

        Fragment createQuestionSettingsFragment = new CreateQuestionSettingsFragment();
        FragmentTransaction createQuestionSettingsTransaction = getFragmentManager().beginTransaction();
        createQuestionSettingsTransaction.add(R.id.createQuestionSettingsFrameSettings, createQuestionSettingsFragment);
        createQuestionSettingsTransaction.commit();

        Bundle furtherArgs = new Bundle();

        furtherArgs.putString("buttonText", buttonText);
        furtherArgs.putBoolean("showFurther", showFurther);

        Fragment createQuestionFurtherFragment = new CreateQuestionFurtherFragment();
        createQuestionFurtherFragment.setArguments(furtherArgs);
        FragmentTransaction createQuestionFurtherTransaction = getFragmentManager().beginTransaction();
        createQuestionFurtherTransaction.add(R.id.createQuestionSettingsFrameFurther, createQuestionFurtherFragment);
        createQuestionFurtherTransaction.commit();
    }

    @Override
    public void further() {
        CreateQuestionExampleFragment exampleFragment = (CreateQuestionExampleFragment) getFragmentManager()
                .findFragmentById(R.id.createQuestionSettingsFrameExample);
        String background = exampleFragment.getBackground();

        CreateQuestionSettingsFragment fragment = (CreateQuestionSettingsFragment) getFragmentManager()
                .findFragmentById(R.id.createQuestionSettingsFrameSettings);

        CreateQuestionModel createQuestionModel = new CreateQuestionModel();

        int audienceType;
        int questionType;

        audienceType = fragment.getOnlyFollowers() ? 1 : 0;
        questionType = fragment.getQuestionAnonimity() ? 2 : 1;

        createQuestionModel.createQuestion(new CreateQuestionRequest(Id.getId(), condition, fragment.getPublicationAnonimity(), audienceType,
                questionType, options.get(0), options.get(1), ServerConnection.getMediaServerAddress(background)));

        Intent intent = new Intent(this, UserActivity.class);

        intent.putExtra("userId", Id.getId());
        intent.putExtra("userLogin", Id.getLogin());

        startActivity(intent);
    }
}
