package com.example.ilya.ourfuture.Markers;

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

        Fragment markersHeaderFragment = new MenuFourFragment(); //It must be below the questionsFragment due to call of questionsFragment into onCreateView method inside MarkersQuestionTypeFragment
        markersHeaderFragment.setArguments(menuArgs);
        FragmentTransaction markersOwnHeaderFt = getFragmentManager().beginTransaction();
        markersOwnHeaderFt.add(R.id.markersFrameMenuFour, markersHeaderFragment);
        markersOwnHeaderFt.commit();

        /*Fragment searchFragment = new UserListSearchFragment();
        FragmentTransaction searchTransaction = getFragmentManager().beginTransaction();
        searchTransaction.add(R.id.markersFrameSearch, searchFragment);
        searchTransaction.commit();

        Fragment questionTypeFragment = new MarkersQuestionTypeFragment();
        FragmentTransaction questionTypeTransaction = getFragmentManager().beginTransaction();
        questionTypeTransaction.add(R.id.markersFrameQuestionsType, questionTypeFragment);
        questionTypeTransaction.commit();*/

        Fragment questionsFragment = new MarkersQuestionsFragment();
        FragmentTransaction questionsTransaction = getFragmentManager().beginTransaction();
        questionsTransaction.add(R.id.markersFrameQuestionList, questionsFragment);
        questionsTransaction.commit();

       /*Fragment markersHeaderFragment = new MarkersOwnHeaderFragment(); //It must be below the questionsFragment due to call of questionsFragment into onCreateView method inside MarkersQuestionTypeFragment
        FragmentTransaction markersOwnHeaderFt = getFragmentManager().beginTransaction();
        markersOwnHeaderFt.add(R.id.markersFrameOwnHeader, markersHeaderFragment);
        markersOwnHeaderFt.commit();*/

        Fragment footerFragment = new FooterFragment();
        FragmentTransaction questionFooterFt = getFragmentManager().beginTransaction();
        questionFooterFt.add(R.id.markersFrameFooter, footerFragment);
        questionFooterFt.commit();
    }

    @Override
    public void onListSelected(int type) {
        FragmentManager fragmentManager = getFragmentManager();

        MarkersQuestionsFragment fragmentQuestions = (MarkersQuestionsFragment) fragmentManager
                .findFragmentById(R.id.markersFrameQuestionList);

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
