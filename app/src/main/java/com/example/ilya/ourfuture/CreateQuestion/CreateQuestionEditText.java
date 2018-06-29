package com.example.ilya.ourfuture.CreateQuestion;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.ilya.ourfuture.R;

/**
 * Created by Ilya on 20.06.2018.
 */

public class CreateQuestionEditText extends LinearLayout {

    View rootView;
    EditText etCondition;

    public CreateQuestionEditText(Context context) {
        super(context);
        init(context);
    }

    public CreateQuestionEditText(Context context, AttributeSet attr) {
        super(context, attr);
        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.create_question_edit_text, this);
        etCondition = rootView.findViewById(R.id.etCreateQuestionText);
    }

    public String getText() {
        return etCondition.getText().toString();
    }

    public void setHintText(String defaultText) {
        etCondition.setHint(defaultText);
    }
}
