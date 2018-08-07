package com.example.ilya.ourfuture.CreateQuestion;

import android.app.Fragment;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.MenuFourFragment;

public class CreateQuestionEditText extends LinearLayout {

    View rootView;
    EditText etCondition;

    Fragment parentFragment;

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

        etCondition.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                CreateQuestionEditText.TextChanged listener = (CreateQuestionEditText.TextChanged) parentFragment;
                listener.editTextChanged(charSequence.length(), rootView);

                System.out.println(charSequence.length());
            }

           @Override
           public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void setParentFragment(Fragment parentFragment) {
        this.parentFragment = parentFragment;
    }

    public String getText() {
        return etCondition.getText().toString();
    }

    public void setHintText(String defaultText) {
        etCondition.setHint(defaultText);
    }

    public interface TextChanged {
        void editTextChanged(int textLength, View rootView);
    }
}
