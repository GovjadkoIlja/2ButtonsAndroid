package com.example.ilya.ourfuture.RegistrationPage;


import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.UserPage.UserActivity;

public class RegisterPropertiesFragment extends Fragment implements IRegisterPropertiesView, View.OnClickListener {

    IRegisterPropertiesPresenter registerPropertiesPresenter;

    Button btnDone;
    EditText etLogin;
    EditText etPassword;
    EditText etPasswordRepeat;
    EditText etPhone;
    EditText etDescription;
    EditText etAge;
    RadioButton rbMale;
    RadioButton rbFemale;

    TextView tvLogin;
    TextView tvPassword;
    TextView tvPasswordRepeat;
    TextView tvAge;

    boolean isLoginHighlighted = false;
    boolean isPasswordHighlighted= false;
    boolean isPasswordRepeatHighlighted= false;
    boolean isPhoneHighlighted= false;
    boolean isDescriptionHighlighted= false;
    boolean isAgeHighlighted= false;
    boolean isSexHighlighted= false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_properties, null);

        etLogin = (EditText)view.findViewById(R.id.etRegisterLogin);
        etPassword = (EditText)view.findViewById(R.id.etRegisterPassword);
        etPasswordRepeat = (EditText)view.findViewById(R.id.etRegisterPasswordRepeat);
        etPhone = (EditText)view.findViewById(R.id.etRegisterPhone);
        etDescription = (EditText)view.findViewById(R.id.etRegisterDescription);
        etAge = (EditText)view.findViewById(R.id.etRegisterAge);
        rbMale = (RadioButton)view.findViewById(R.id.radioButtonMale);
        rbFemale = (RadioButton)view.findViewById(R.id.radioButtonFemale);
        btnDone = (Button)view.findViewById(R.id.btnRegisterDone);

        tvLogin = (TextView)view.findViewById(R.id.tvRegisterLogin);
        tvPassword = (TextView)view.findViewById(R.id.tvRegisterPassword);
        tvPasswordRepeat = (TextView)view.findViewById(R.id.tvRegisterPasswordRepeat);
        tvAge = (TextView)view.findViewById(R.id.tvRegisterWrongAge);

        btnDone.setOnClickListener(this);
        rbMale.setOnClickListener(this);
        rbFemale.setOnClickListener(this);

        setTextChangesHandlers();

        if (registerPropertiesPresenter == null) {
            registerPropertiesPresenter  = new RegisterPropertiesPresenter(this);
        }

        return view;
    }

    @Override
    public void buttonRegisterClicked() {
        String login = etLogin.getText().toString();
        String password = etPassword.getText().toString();
        String passwordRepeat = etPasswordRepeat.getText().toString();
        String phone = etPhone.getText().toString();
        String description = etDescription.getText().toString();
        String age = etAge.getText().toString();
        int sex = -1;
        if (rbMale.isChecked())
            sex = 1;
        else if (rbFemale.isChecked())
            sex = 0;

        registerPropertiesPresenter.register(login, password, passwordRepeat, phone, description, age, sex);
    }

    @Override
    public void wrongLoginManager(boolean show) {
        if (show)
            tvLogin.setVisibility(View.VISIBLE);
        else
            tvLogin.setVisibility(View.INVISIBLE);
    }

    @Override
    public void wrongPasswordManager(boolean show) {
        if (show)
            tvPassword.setVisibility(View.VISIBLE);
        else
            tvPassword.setVisibility(View.INVISIBLE);
    }

    @Override
    public void wrongPasswordRepeatManager(boolean show) {
        if (show)
            tvPasswordRepeat.setVisibility(View.VISIBLE);
        else
            tvPasswordRepeat.setVisibility(View.INVISIBLE);
    }

    @Override
    public void wrongAgeManager(boolean show) {
        if (show)
            tvAge.setVisibility(View.VISIBLE);
        else
            tvAge.setVisibility(View.INVISIBLE);
    }

    @Override
    public void markLoginField(boolean isWrong) {
        if (isWrong) {
            isLoginHighlighted = true;
            etLogin.setBackgroundResource(R.drawable.wrong_property_border);
        }
        else {
            isLoginHighlighted = false;
            etLogin.setBackgroundResource(R.drawable.credentials_border);
        }
    }

    @Override
    public void markPasswordField(boolean isWrong) {
        if (isWrong) {
            isPasswordHighlighted = true;
            etPassword.setBackgroundResource(R.drawable.wrong_property_border);
        }
        else {
            isPasswordHighlighted = false;
            etPassword.setBackgroundResource(R.drawable.credentials_border);
        }
    }

    @Override
    public void markPasswordRepeatField(boolean isWrong) {
        if (isWrong) {
            isPasswordRepeatHighlighted = true;
            etPasswordRepeat.setBackgroundResource(R.drawable.wrong_property_border);
        }
        else {
            isPasswordRepeatHighlighted = false;
            etPasswordRepeat.setBackgroundResource(R.drawable.credentials_border);
        }
    }

    @Override
    public void markAgeField(boolean isWrong) {
        if (isWrong) {
            isAgeHighlighted = true;
            etAge.setBackgroundResource(R.drawable.wrong_property_border);
        }
        else {
            isAgeHighlighted = false;
            etAge.setBackgroundResource(R.drawable.credentials_border);
        }
    }

    @Override
    public void markSexField(boolean isWrong) {

        int color;
        int textColor;

        if (isWrong) {
            isSexHighlighted = true;
            color = getResources().getColor(R.color.colorWrongBoarder);
            textColor = getResources().getColor(R.color.colorWrongBoarder);
        }
        else {
            color = getResources().getColor(R.color.colorBlue);
            textColor = Color.BLACK;
        }

        ColorStateList colorStateList = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_checked},
                        new int[]{android.R.attr.state_checked}
                },
                new int[]{color, color}
        );
        //rbMale.setBackgroundTintList(colorStateList);
        rbMale.setButtonTintList(colorStateList);
        rbFemale.setButtonTintList(colorStateList);

        rbMale.setTextColor(textColor);
        rbFemale.setTextColor(textColor);
    }

    @Override
    public void openApplication(int id) {
        Intent intent = new Intent(this.getActivity(), UserActivity.class);
        intent.putExtra("userId", Id.getId());
        intent.putExtra("fromRegistration", true);
        startActivity(intent);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.btnRegisterDone):
                buttonRegisterClicked();
                break;
            case (R.id.radioButtonMale):
            case (R.id.radioButtonFemale):
                markSexField(false); //We can execute it each time, because it's seldome choise
                break;
        }
    }

    public void setTextChangesHandlers()  {
        etLogin.addTextChangedListener(new TextWatcher() {
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (isLoginHighlighted)
                    markLoginField(false);
                registerPropertiesPresenter.checkLogin(etLogin.getText().toString());
            }
        });

        etPassword.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                if (isPasswordHighlighted)
                    markPasswordField(false);
                registerPropertiesPresenter.checkPassword(etPassword.getText().toString());
                registerPropertiesPresenter.checkPasswordRepeat(etPassword.getText().toString(), etPasswordRepeat.getText().toString());
            }
        });

        etPasswordRepeat.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                if (isPasswordRepeatHighlighted)
                    markPasswordRepeatField(false);
                registerPropertiesPresenter.checkPasswordRepeat(etPassword.getText().toString(), etPasswordRepeat.getText().toString());
            }
        });

        etAge.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                if (isAgeHighlighted)
                    markAgeField(false);
                registerPropertiesPresenter.checkAge(etAge.getText().toString());
            }
        });
    }
}
