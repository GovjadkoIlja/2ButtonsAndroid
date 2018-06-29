package com.example.ilya.ourfuture.CreateQuestion;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ilya.ourfuture.Question.Question;
import com.example.ilya.ourfuture.Question.QuestionView;
import com.example.ilya.ourfuture.Question.QuestionsListFragment;
import com.example.ilya.ourfuture.Question.QuestionsListPresenter;
import com.example.ilya.ourfuture.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateQuestionExampleFragment extends Fragment {

    TextView tvLogin;
    TextView tvCondition;
    TextView tvType;
    TextView tvAnswers;
    TextView tvRaiting;
    TextView tvAskDate;
    ImageView ivAnswered;
    ImageButton ibLike;
    ImageButton ibDislike;
    ImageButton ibFavorite;

    TextView tvFirstOption;
    TextView tvSecondOption;

    RelativeLayout rlFirstOption;
    RelativeLayout rlSecondOption;

    QuestionView questionView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_question_example, container, false);

        Bundle exampleArgs = getArguments();

        questionView = view.findViewById(R.id.createQuestionExampleQuestion);

        String condition = exampleArgs.getString("condition");
        ArrayList<String> options = exampleArgs.getStringArrayList("options");
        Question question = new Question(condition, options.get(0), options.get(1), "AAA", 1);

        questionView.setData(question);

        /*tvCondition = view.findViewById(R.id.tvClosedQuestionCondition);

        tvCondition.setText("AAAAA");*/

        return view;
    }

}
