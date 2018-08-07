package com.example.ilya.ourfuture.LoginPage;

import android.content.Context;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ilya.ourfuture.Question.QuestionPresenter;
import com.example.ilya.ourfuture.R;

/**
 * Created by Ilya on 12.07.2018.
 */

public class CredentialsEditText extends LinearLayout {

    View rootView;
    EditText etCredential;

    public CredentialsEditText(Context context) {
        super(context);
        init(context);
    }

    public CredentialsEditText(Context context, AttributeSet attr) {
        super(context, attr);
        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.credentials_edit_text, this);
        etCredential = rootView.findViewById(R.id.etCredentialsEditText);
    }

    public void setHint(String hint) {
        etCredential.setHint(hint);
    }

    public void setText(String text) {
        etCredential.setText(text);
    }

    public String getText() {
        return etCredential.getText().toString();
    }

    public void setTextType(boolean isPassword) {
        if (isPassword)
            etCredential.setTransformationMethod(new PasswordTransformationMethod());
        else
            etCredential.setTransformationMethod(null);
    }
}
