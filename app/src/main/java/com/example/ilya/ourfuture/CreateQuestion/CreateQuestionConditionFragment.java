package com.example.ilya.ourfuture.CreateQuestion;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ilya.ourfuture.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateQuestionConditionFragment extends Fragment {

    CreateQuestionEditText cqCondition;
    CreateQuestionEditText cqOption1;
    CreateQuestionEditText cqOption2;

    final String conditionHint = "Условие вопроса";
    final String firstOptionHint = "Первый вариант ответа";
    final String secondOptionHint = "Второй вариант ответа";

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

}
