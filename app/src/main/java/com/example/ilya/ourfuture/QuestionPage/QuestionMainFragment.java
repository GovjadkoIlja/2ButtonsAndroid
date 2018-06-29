package com.example.ilya.ourfuture.QuestionPage;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Question.Question;

import java.util.ArrayList;


public class QuestionMainFragment extends Fragment implements IQuestionMainView, View.OnClickListener {

    IQuestionMainPresenter questionMainPresenter;

    TextView tvCondition;
    TextView tvFirstOption;
    TextView tvSecondOption;
    TextView tvFirstAnswers;
    TextView tvSecondAnswers;
    TextView tvFirstPercent;
    TextView tvSecondPercent;
    RelativeLayout rlFirstOption;
    RelativeLayout rlSecondOption;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_question_main, null);

        Bundle args = getArguments();

        int position = args.getInt("position");
        ArrayList<Question> questions = (ArrayList<Question>) args.getSerializable("questions");

        questionMainPresenter = new QuestionMainPresenter(Id.getId(), this);

        tvCondition = view.findViewById(R.id.tvQuestionCondition);
        tvFirstOption = view.findViewById(R.id.tvFirstOption);
        tvSecondOption = view.findViewById(R.id.tvSecondOption);

        /*tvCondition.setText(QuestionsList.getNextQuestion().condition);
        tvFirstOption.setText(QuestionsList.getNextQuestion().firstOption);
        tvSecondOption.setText(QuestionsList.getNextQuestion().secondOption);*/

        tvFirstAnswers = view.findViewById(R.id.tvFirstAnswers);
        tvSecondAnswers = view.findViewById(R.id.tvSecondAnswers);
        tvFirstPercent = view.findViewById(R.id.tvFirstPercent);
        tvSecondPercent = view.findViewById(R.id.tvSecondPercent);

        rlFirstOption = view.findViewById(R.id.rlFirstOption);
        rlSecondOption = view.findViewById(R.id.rlSecondOption);

        rlFirstOption.setOnClickListener(this);
        rlSecondOption.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        int option = 0;
        switch (view.getId()) {
            case (R.id.rlFirstOption):
                option = 1;
                break;
            case (R.id.rlSecondOption):
                option = 2;
                break;

        }

        questionMainPresenter.optionClicked(option);
    }

    @Override
    public void representAnswers(int firstAnswer, int secondAnswer) {
        tvFirstAnswers.setText(firstAnswer + "");
        tvSecondAnswers.setText(secondAnswer + "");
    }

    @Override
    public void representPercents(int firstPercent, int secondPercent) {
        tvFirstPercent.setText(firstPercent + "%");
        tvSecondPercent.setText(secondPercent + "%");
    }

    @Override
    public void representYourAnswer(int yourAnswer) {
        if (yourAnswer == 1) {
            tvFirstOption.setTypeface(null, Typeface.BOLD);
            tvFirstAnswers.setTypeface(null, Typeface.BOLD);
            tvFirstPercent.setTypeface(null, Typeface.BOLD);

            setOptionColor(1, getResources().getColor(R.color.colorAnsweredOptionText));
            setOptionColor(2, getResources().getColor(R.color.colorNotAnsweredOptionText));
        } else if (yourAnswer == 2) {
            tvSecondOption.setTypeface(null, Typeface.BOLD);
            tvSecondAnswers.setTypeface(null, Typeface.BOLD);
            tvSecondPercent.setTypeface(null, Typeface.BOLD);

            setOptionColor(2, getResources().getColor(R.color.colorAnsweredOptionText));
            setOptionColor(1, getResources().getColor(R.color.colorNotAnsweredOptionText));
        }
    }

    @Override
    public void getPeopleList(int id, int questionId, int option, String firstOption, String secondOption) {
        Intent intent = new Intent(this.getActivity(), QuestionPeopleListActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("questionId", questionId);
        intent.putExtra("option", option);
        intent.putExtra("firstOption", firstOption);
        intent.putExtra("secondOption", secondOption);

        startActivity(intent);
    }

    private void setOptionColor(int option, int color) {
        if (option == 1) {
            tvFirstOption.setTextColor(color);
            tvFirstAnswers.setTextColor(color);
            tvFirstPercent.setTextColor(color);
        } else if (option == 2) {
            tvSecondOption.setTextColor(color);
            tvSecondAnswers.setTextColor(color);
            tvSecondPercent.setTextColor(color);
        }
    }
}
