package com.TwoButtons.ilya.TwoButtons.Markers;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.TwoButtons.ilya.TwoButtons.Shared.FooterFragment;
import com.TwoButtons.ilya.TwoButtons.Shared.HeaderFragment;
import com.TwoButtons.ilya.TwoButtons.Shared.MenuFourFragment;
import com.android.ilya.TwoButtons.R;
import com.TwoButtons.ilya.TwoButtons.Shared.ErrorFragment;

import java.util.ArrayList;

public class MarkersActivity extends Activity implements MenuFourFragment.OnSelectedListListener {

    final String header = "Закладки";
    boolean showBack = true;
    final String[] menu = {"Мое", "Понравилось", "Сохранено", "Рекомендации"};

    ArrayList<String> menuStrings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markers);

        Bundle headerArgs = new Bundle();
        headerArgs.putString("headerText", header);
        headerArgs.putBoolean("showBack", showBack);

        Fragment headerFragment = new HeaderFragment();
        headerFragment.setArguments(headerArgs);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.markersFrameHeader, headerFragment);
        ft.commit();

        ArrayList<String> menuStrings = fillMenuArray(menu);
        Bundle menuArgs = new Bundle();
        menuArgs.putStringArrayList("menuStrings", menuStrings);

        Fragment markersHeaderFragment = new MenuFourFragment();
        markersHeaderFragment.setArguments(menuArgs);
        FragmentTransaction markersOwnHeaderFt = getFragmentManager().beginTransaction();
        markersOwnHeaderFt.add(R.id.markersFrameMenuFour, markersHeaderFragment);
        markersOwnHeaderFt.commit();

        Fragment questionsFragment = new MarkersQuestionsFragment();
        FragmentTransaction questionsTransaction = getFragmentManager().beginTransaction();
        questionsTransaction.add(R.id.markersFrameQuestionList, questionsFragment);
        questionsTransaction.commit();


        Fragment footerFragment = new FooterFragment();
        FragmentTransaction questionFooterFt = getFragmentManager().beginTransaction();
        questionFooterFt.add(R.id.markersFrameFooter, footerFragment);
        questionFooterFt.commit();
    }

    @Override
    public void onListSelected(int type) {
        FragmentManager fragmentManager = getFragmentManager();

        MarkersQuestionsFragment questionsFragment;

        boolean isFromErrorFragment = fragmentManager
                .findFragmentById(R.id.markersFrameQuestionList).getClass() == ErrorFragment.class;

        if (!isFromErrorFragment) {
            questionsFragment = (MarkersQuestionsFragment) fragmentManager
                    .findFragmentById(R.id.markersFrameQuestionList);

        } else {
            ErrorFragment errorFragment = (ErrorFragment) fragmentManager
                    .findFragmentById(R.id.markersFrameQuestionList);

            getFragmentManager().beginTransaction().remove(errorFragment).commit();

            questionsFragment = new MarkersQuestionsFragment();
            FragmentTransaction questionsTransaction = getFragmentManager().beginTransaction();
            questionsTransaction.replace(R.id.markersFrameQuestionList, questionsFragment);
            questionsTransaction.commit();
        }

        if (questionsFragment != null) {
            questionsFragment.questionsTypeChanged(type, isFromErrorFragment);
        }
    }

    private ArrayList<String> fillMenuArray(String[] menu) {
        ArrayList<String> menuStrings = new ArrayList<>();

        for (int i = 0; i < menu.length; i++)
            menuStrings.add(menu[i]);

        return menuStrings;
    }
}
