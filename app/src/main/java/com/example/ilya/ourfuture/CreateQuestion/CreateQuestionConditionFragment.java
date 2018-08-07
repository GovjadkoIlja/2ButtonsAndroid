package com.example.ilya.ourfuture.CreateQuestion;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ilya.ourfuture.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateQuestionConditionFragment extends Fragment implements CreateQuestionEditText.TextChanged {

    CreateQuestionEditText cqCondition;
    CreateQuestionEditText cqOption1;
    CreateQuestionEditText cqOption2;

    TextView tvConditionSimbols;
    TextView tvOptionsSimbols;

    final String conditionHint = "Условие вопроса";
    final String firstOptionHint = "Первый вариант ответа";
    final String secondOptionHint = "Второй вариант ответа";

    final int conditionLength = 250;
    final int optionLength = 200;

    boolean isConditionCorrect = false;
    boolean isOption1Correct = false;
    boolean isOption2Correct = false;

    public CreateQuestionConditionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_create_question_condition, container, false);

        cqCondition = view.findViewById(R.id.cqCondition);
        cqOption1 = view.findViewById(R.id.cqOption1);
        cqOption2 = view.findViewById(R.id.cqOption2);

        tvConditionSimbols = view.findViewById(R.id.tvCreateQuestionConditionSimbols);
        tvOptionsSimbols = view.findViewById(R.id.tvCreateQuestionOptionsSimbols);

        cqCondition.setParentFragment(this);
        cqOption1.setParentFragment(this);
        cqOption2.setParentFragment(this);

        cqCondition.setHintText(conditionHint);
        cqOption1.setHintText(firstOptionHint);
        cqOption2.setHintText(secondOptionHint);

        return view;
    }

    public String getCondition(){
        return cqCondition.getText();
    }

    public ArrayList<String> getOptions(){
        ArrayList<String> options = new ArrayList<>();

        options.add(cqOption1.getText());
        options.add(cqOption2.getText());

        return options;
    }

    @Override
    public void editTextChanged(int textLength, View view) {

        TextView viewToChange = getTextViewToChange(view);

        int maxLength = getMaxLength(viewToChange);

        boolean isCorrect = true;
        boolean wasCorrect = isAllCorrect();

        if (textLength == 0) {
            viewToChange.setVisibility(View.INVISIBLE);
            isCorrect = false;
        }
        else if (viewToChange.getVisibility() == View.INVISIBLE) {
            viewToChange.setVisibility(View.VISIBLE);
            isCorrect = true;
        }
        else if (textLength == maxLength) {
            viewToChange.setTextColor(getResources().getColor(R.color.colorBlack));
            view.setBackgroundColor(getResources().getColor(R.color.colorWhite));

            isCorrect = true;
        }
        else if (textLength == maxLength + 1) {
            viewToChange.setTextColor(getResources().getColor(R.color.colorLongText));
            view.setBackgroundColor(getResources().getColor(R.color.colorLongField));

            isCorrect = false;
        }
        else if (textLength > maxLength + 1) {
            isCorrect = false;
        }

        setCorrectness(view, isCorrect);
        boolean nowCorrect = isAllCorrect();

        if (wasCorrect != nowCorrect) {
            LongCondition longCondition = (LongCondition) getActivity();
            longCondition.changeFurtherButtonState(nowCorrect);
        }

        viewToChange.setText(textLength + "/" + getMaxLength(viewToChange));
    }

    private TextView getTextViewToChange(View view) {
        if (view.getId() == cqCondition.getId())
            return tvConditionSimbols;
        else
            return tvOptionsSimbols;
    }

    private int getMaxLength(TextView view) {
        if (view == tvConditionSimbols)
            return conditionLength;
        else
            return optionLength;
    }

    private boolean isAllCorrect() {
        return isConditionCorrect && isOption1Correct && isOption2Correct;
    }

    private void setCorrectness(View view, boolean isCorrect) {

        switch (view.getId()) {
            case (R.id.cqCondition):
                isConditionCorrect = isCorrect;
                break;
            case (R.id.cqOption1):
                isOption1Correct = isCorrect;
                break;
            case (R.id.cqOption2):
                isOption2Correct = isCorrect;
                break;
        }
    }

    public interface LongCondition {
        void changeFurtherButtonState(boolean isEnabled);
    }
}
