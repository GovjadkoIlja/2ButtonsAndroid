package com.example.ilya.ourfuture.CreateQuestion;


import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ilya.ourfuture.Question.Question;
import com.example.ilya.ourfuture.Question.QuestionView;
import com.example.ilya.ourfuture.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateQuestionExampleFragment extends Fragment implements QuestionView.ChangingBackgroundClicked {

    CreateQuestionExamplePresenter createQuestionExamplePresenter;

    QuestionView questionView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Configuration configuration = getResources().getConfiguration();
        int screenWidthDp = configuration.screenWidthDp;
        System.out.println(screenWidthDp + " QQQQQQQQ");

        View view = inflater.inflate(R.layout.fragment_create_question_example, container, false);

        Bundle exampleArgs = getArguments();

        questionView = view.findViewById(R.id.createQuestionExampleQuestion);

        createQuestionExamplePresenter = new CreateQuestionExamplePresenter(this);

        createQuestionExamplePresenter.getStandardBackgrounds();

        String condition = exampleArgs.getString("condition");
        ArrayList<String> options = exampleArgs.getStringArrayList("options");
        Question question = new Question(condition, options.get(0), options.get(1), "AAA", 1);

        questionView.setData(question);
        questionView.setParentFragment(this);
        questionView.makeBackgroundArrowsVisible();

        /*tvCondition = view.findViewById(R.id.tvClosedQuestionCondition);

        tvCondition.setText("AAAAA");*/

        return view;
    }

    public void setBackground(String url) {
        questionView.setBackgroundImage(url);
    }

    public String getBackground() {
        return createQuestionExamplePresenter.getBackground(0);
    }

    @Override
    public void changeBackground(int offset) {
        String url = createQuestionExamplePresenter.getBackground(offset);

        questionView.setBackgroundImage(url);
    }
}
