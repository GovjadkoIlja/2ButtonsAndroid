package com.example.ilya.ourfuture.Selection;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.FooterFragment;
import com.example.ilya.ourfuture.Shared.HeaderFragment;
import com.example.ilya.ourfuture.Shared.MenuFourFragment;
import com.example.ilya.ourfuture.Tops.TopQuestionsFragment;

import java.util.ArrayList;

public class SelectionActivity extends Activity {

    final String header = "Подобрать вопрос";
    boolean showBack = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        Bundle headerArgs = new Bundle();
        headerArgs.putString("headerText", header);
        headerArgs.putBoolean("showBack", showBack);

        Fragment headerFragment = new HeaderFragment();
        headerFragment.setArguments(headerArgs);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.selectionFrameHeader, headerFragment);
        ft.commit();

        Fragment questionsFragment = new SelectionQuestionsFragment();
        FragmentTransaction questionsTransaction = getFragmentManager().beginTransaction();
        questionsTransaction.add(R.id.selectionFrameQuestionList, questionsFragment);
        questionsTransaction.commit();

        Fragment footerFragment = new FooterFragment();
        FragmentTransaction questionFooterFt = getFragmentManager().beginTransaction();
        questionFooterFt.add(R.id.selectionFrameFooter, footerFragment);
        questionFooterFt.commit();
    }
}
