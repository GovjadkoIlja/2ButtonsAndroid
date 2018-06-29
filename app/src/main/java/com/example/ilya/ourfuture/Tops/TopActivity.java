package com.example.ilya.ourfuture.Tops;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.FooterFragment;
import com.example.ilya.ourfuture.Shared.HeaderFragment;
import com.example.ilya.ourfuture.Shared.MenuFourFragment;

import java.util.ArrayList;

public class TopActivity extends Activity implements MenuFourFragment.OnSelectedListListener {

    final String header = "Лучшее";
    boolean showBack = true;
    final String[] menu = {"За сегодня", "За неделю", "За месяц", "За всё время"};

    ArrayList<String> menuStrings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tops);

        Bundle headerArgs = new Bundle();
        headerArgs.putString("headerText", header);
        headerArgs.putBoolean("showBack", showBack);

        Fragment headerFragment = new HeaderFragment();
        headerFragment.setArguments(headerArgs);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.topsFrameHeader, headerFragment);
        ft.commit();

        ArrayList<String> menuStrings = fillMenuArray(menu);
        Bundle menuArgs = new Bundle();
        menuArgs.putStringArrayList("menuStrings", menuStrings);

        Fragment topsHeaderFragment = new MenuFourFragment(); //It must be below the questionsFragment due to call of questionsFragment into onCreateView method inside MarkersQuestionTypeFragment
        topsHeaderFragment.setArguments(menuArgs);
        FragmentTransaction markersOwnHeaderFt = getFragmentManager().beginTransaction();
        markersOwnHeaderFt.add(R.id.topsFrameMenuFour, topsHeaderFragment);
        markersOwnHeaderFt.commit();

        /* searchFragment = new UserListSearchFragment();
        FragmentTransaction searchTransaction = getFragmentManager().beginTransaction();
        searchTransaction.add(R.id.markersFrameSearch, searchFragment);
        searchTransaction.commit();

        Fragment questionTypeFragment = new MarkersQuestionTypeFragment();
        FragmentTransaction questionTypeTransaction = getFragmentManager().beginTransaction();
        questionTypeTransaction.add(R.id.markersFrameQuestionsType, questionTypeFragment);
        questionTypeTransaction.commit();*/

        Fragment questionsFragment = new TopQuestionsFragment();
        FragmentTransaction questionsTransaction = getFragmentManager().beginTransaction();
        questionsTransaction.add(R.id.topsFrameQuestionList, questionsFragment);
        questionsTransaction.commit();

        Fragment footerFragment = new FooterFragment();
        FragmentTransaction questionFooterFt = getFragmentManager().beginTransaction();
        questionFooterFt.add(R.id.topsFrameFooter, footerFragment);
        questionFooterFt.commit();
    }

    @Override
    public void onListSelected(int type) {
        FragmentManager fragmentManager = getFragmentManager();

        TopQuestionsFragment fragmentQuestions = (TopQuestionsFragment) fragmentManager
                .findFragmentById(R.id.topsFrameQuestionList);

        if (fragmentQuestions != null) {
            System.out.println("AAAAAAA");
            fragmentQuestions.questionsTypeChanged(type);
        }
    }

    private ArrayList<String> fillMenuArray(String[] menu) {
        ArrayList<String> menuStrings = new ArrayList<>();

        for (int i = 0; i < menu.length; i++)
            menuStrings.add(menu[i]);

        return menuStrings;
    }
}
