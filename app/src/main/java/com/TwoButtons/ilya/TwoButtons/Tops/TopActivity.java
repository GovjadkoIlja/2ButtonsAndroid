package com.TwoButtons.ilya.TwoButtons.Tops;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.TwoButtons.ilya.TwoButtons.Shared.FooterFragment;
import com.TwoButtons.ilya.TwoButtons.Shared.HeaderFragment;
import com.TwoButtons.ilya.TwoButtons.Shared.MenuFourFragment;
import com.TwoButtons.ilya.TwoButtons.Shared.ErrorFragment;
import com.android.ilya.TwoButtons.R;

import java.util.ArrayList;

public class TopActivity extends Activity implements MenuFourFragment.OnSelectedListListener {

    final String header = "Лучшее";
    boolean showBack = true;
    final String[] menu = {"Cегодня", "Неделя", "Месяц", "Всё время"};

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

        Fragment topsHeaderFragment = new MenuFourFragment();
        topsHeaderFragment.setArguments(menuArgs);
        FragmentTransaction markersOwnHeaderFt = getFragmentManager().beginTransaction();
        markersOwnHeaderFt.add(R.id.topsFrameMenuFour, topsHeaderFragment);
        markersOwnHeaderFt.commit();

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

        TopQuestionsFragment questionsFragment;

        boolean isFromErrorFragment = fragmentManager
                .findFragmentById(R.id.topsFrameQuestionList).getClass() == ErrorFragment.class;

        if (!isFromErrorFragment) {
            questionsFragment = (TopQuestionsFragment) fragmentManager
                    .findFragmentById(R.id.topsFrameQuestionList);
        } else {
            ErrorFragment errorFragment = (ErrorFragment) fragmentManager
                    .findFragmentById(R.id.topsFrameQuestionList);

            getFragmentManager().beginTransaction().remove(errorFragment).commit();

            questionsFragment = new TopQuestionsFragment();
            FragmentTransaction questionsTransaction = getFragmentManager().beginTransaction();
            questionsTransaction.replace(R.id.topsFrameQuestionList, questionsFragment);
            questionsTransaction.commit();
        }

        /*try { //If before it was an error

        }
        catch (Exception e) {
            questionsFragment = new TopQuestionsFragment();
            FragmentTransaction questionsTransaction = getFragmentManager().beginTransaction();
            questionsTransaction.add(R.id.topsFrameQuestionList, questionsFragment);
            questionsTransaction.commit();
        }*/

        System.out.println(isFromErrorFragment);

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
