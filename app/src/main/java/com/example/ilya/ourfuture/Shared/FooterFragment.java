package com.example.ilya.ourfuture.Shared;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.ilya.ourfuture.CreateQuestionActivity;
import com.example.ilya.ourfuture.Markers.MarkersActivity;
import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.UserPage.UserActivity;

public class FooterFragment extends Fragment implements View.OnClickListener {

    static int selectedOption = 1;

    ImageButton ibUser;
    ImageButton ibNews;
    ImageButton ibAsk;
    ImageButton ibQuestions;
    ImageButton ibBest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_footer, null);

        Bundle args = getArguments();

        ibUser = view.findViewById(R.id.ibFooterUser);
        ibNews = view.findViewById(R.id.ibFooterNews);
        ibAsk = view.findViewById(R.id.ibFooterAsk);
        ibQuestions = view.findViewById(R.id.ibFooterQuestions);
        ibBest = view.findViewById(R.id.ibFooterBest);

        ibUser.setOnClickListener(this);
        ibNews.setOnClickListener(this);
        ibAsk.setOnClickListener(this);
        ibQuestions.setOnClickListener(this);
        ibBest.setOnClickListener(this);

        setSelectedOption(selectedOption);

        return view;
    }

    @Override
    public void onClick(View view) {

        Intent intent = null;
        int newSelectedOption = 1;

        switch (view.getId()) {
            case R.id.ibFooterUser:
                newSelectedOption = 1;
                intent = new Intent(this.getActivity(), UserActivity.class);
                intent.putExtra("userId", Id.getId());
                break;

            case R.id.ibFooterBest:
                newSelectedOption = 5;
                intent = new Intent(this.getActivity(), MarkersActivity.class);
                break;

            case R.id.ibFooterAsk:
                newSelectedOption = 3;
                intent = new Intent(this.getActivity(), CreateQuestionActivity.class);
                break;

            case R.id.ibFooterNews:
            case R.id.ibFooterQuestions:
                return;
        }

        setSelectedOption(newSelectedOption);

        startActivity(intent);
    }

    private void setSelectedOption(int newOption) {
        switch (selectedOption) {
            case 1:
                ibUser.setImageResource(R.drawable.userpage_disabled);
                break;
            case 2:
                ibNews.setImageResource(R.drawable.news_disabled);
                break;
            case 3:
                ibAsk.setImageResource(R.drawable.ask_question_disabled);
                break;
            case 4:
                ibQuestions.setImageResource(R.drawable.questions_list_disabled);
                break;
            case 5:
                ibBest.setImageResource(R.drawable.best_disabled);
                break;
        }

        switch (newOption) {
            case 1:
                ibUser.setImageResource(R.drawable.userpage_enabled);
                break;
            case 2:
                ibNews.setImageResource(R.drawable.news_enabled);
                break;
            case 3:
                ibAsk.setImageResource(R.drawable.ask_question_enabled);
                break;
            case 4:
                ibQuestions.setImageResource(R.drawable.questions_list_enabled);
                break;
            case 5:
                ibBest.setImageResource(R.drawable.best_enabled);
                break;
        }

        selectedOption = newOption;
    }
}
