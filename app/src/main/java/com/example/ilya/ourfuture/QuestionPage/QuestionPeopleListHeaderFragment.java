package com.example.ilya.ourfuture.QuestionPage;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ilya.ourfuture.R;

public class QuestionPeopleListHeaderFragment extends Fragment implements View.OnClickListener {

    final int buttonTextMaxLength = 12;

    Button btnFirstOption;
    Button btnSecondOption;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_people_list_header, null);

        Bundle args = getArguments();

        int option = args.getInt("option", 1);
        String firstOption = args.getString("firstOption");
        String secondOption = args.getString("secondOption");

        btnFirstOption = view.findViewById(R.id.btnQuestionPeopleListHeaderFirstOption);
        btnSecondOption = view.findViewById(R.id.btnQuestionPeopleListHeaderSecondOption);

        btnFirstOption.setOnClickListener(this);
        btnSecondOption.setOnClickListener(this);

        setButtonTexts(firstOption, secondOption);
        setButtonsStyle(option);

        return view;
    }

    private void setButtonTexts(String firstOption, String secondOption) {
        //int firstMaxLength = buttonTextMaxLength < firstOption.length() ? buttonTextMaxLength : firstOption.length();
        int firstMaxLength = Math.min(buttonTextMaxLength, firstOption.length());
        String firstButtonText;
        if (firstMaxLength == firstOption.length())
            firstButtonText = "1. " + firstOption;
        else
            firstButtonText = "1. " + firstOption.substring(0, firstMaxLength) + "...";
        btnFirstOption.setText(firstButtonText);

        int secondMaxLength = Math.min(buttonTextMaxLength, secondOption.length());
        String secondButtonText;
        if (secondMaxLength == secondOption.length())
            secondButtonText = "2. " + secondOption;
        else
            secondButtonText = "2. " + secondOption.substring(0, secondMaxLength) + "...";
        btnSecondOption.setText(secondButtonText);
    }

    @Override
    public void onClick(View view) {

        int option = 1;

        switch (view.getId()) {
            case R.id.btnQuestionPeopleListHeaderFirstOption:
                option = 1;
                break;
            case R.id.btnQuestionPeopleListHeaderSecondOption:
                option = 2;
                break;
        }

        setButtonsStyle(option);
        OnSelectedOptionListener listener = (OnSelectedOptionListener) getActivity();
        listener.onOptionSelected(option);
    }

    private void setButtonsStyle(int option) {
        if (option == 1) {
            setSelected(btnFirstOption);
            setUnselected(btnSecondOption);
        } else {
            setUnselected(btnFirstOption);
            setSelected(btnSecondOption);
        }
    }

    private void setSelected(Button btn) {
        btn.setBackgroundColor(getResources().getColor(R.color.colorBlue));
        btn.setTextColor(getResources().getColor(R.color.colorWhite));
    }

    private void setUnselected(Button btn) {
        btn.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        btn.setTextColor(getResources().getColor(R.color.colorBlue));
    }

    public interface OnSelectedOptionListener {
        void onOptionSelected(int option);
    }

}
