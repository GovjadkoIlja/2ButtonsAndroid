package com.TwoButtons.ilya.TwoButtons.News;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.TwoButtons.ilya.TwoButtons.Question.QuestionView;
import com.android.ilya.TwoButtons.R;

/**
 * Created by Ilya on 01.07.2018.
 */

public class NewsQuestionView extends LinearLayout {

    View rootView;
    QuestionView questionView;
    TextView tvDescription;

    public NewsQuestionView(Context context) {
        super(context);
        init(context);
    }

    public NewsQuestionView(Context context, AttributeSet attr) {
        super(context, attr);
        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.news_question, this);

        questionView = rootView.findViewById(R.id.nqQuestion);
        tvDescription = rootView.findViewById(R.id.nqDescription);
    }

    public void representQuestion(NewsQuestion question) {
        questionView.setData(question);
        tvDescription.setText(question.getDescription());
    }
}