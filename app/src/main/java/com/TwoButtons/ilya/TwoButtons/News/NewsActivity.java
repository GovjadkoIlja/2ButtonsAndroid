package com.TwoButtons.ilya.TwoButtons.News;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.TwoButtons.ilya.TwoButtons.Shared.FooterFragment;
import com.TwoButtons.ilya.TwoButtons.Shared.HeaderFragment;
import com.android.ilya.TwoButtons.R;

public class NewsActivity extends Activity {

    final String header = "Новости";
    boolean showBack = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        Bundle headerArgs = new Bundle();
        headerArgs.putString("headerText", header);
        headerArgs.putBoolean("showBack", showBack);

        Fragment headerFragment = new HeaderFragment();
        headerFragment.setArguments(headerArgs);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.newsFrameHeader, headerFragment);
        ft.commit();

        Fragment questionsFragment = new NewsQuestionsFragment();
        FragmentTransaction questionsTransaction = getFragmentManager().beginTransaction();
        questionsTransaction.add(R.id.newsFrameQuestionList, questionsFragment);
        questionsTransaction.commit();

        Fragment footerFragment = new FooterFragment();
        FragmentTransaction questionFooterFt = getFragmentManager().beginTransaction();
        questionFooterFt.add(R.id.newsFrameFooter, footerFragment);
        questionFooterFt.commit();
    }
}
