package com.example.ilya.ourfuture.LoginPage;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.RegistrationPage.RegisterActivity;
import com.example.ilya.ourfuture.UserPage.UserActivity;

public class CredentialsFragment extends Fragment implements ICredentialsView, View.OnClickListener {

    Button btnLogin;
    Button btnRegister;
    EditText etLogin;
    EditText etPassword;

    ICredentialsPresenter credentialsPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_credentials, null);

        etLogin = (EditText)view.findViewById(R.id.etLogin);
        etPassword = (EditText)view.findViewById(R.id.etPassword);
        btnLogin = (Button)view.findViewById(R.id.btnLogin);
        btnRegister = (Button)view.findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

        if (credentialsPresenter == null) {
            credentialsPresenter = new CredentialsPresenter(this);
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.btnLogin):
                onLoginButtonClick();
                break;
            case (R.id.btnRegister):
                Intent intent = new Intent(this.getActivity(), RegisterActivity.class);
                startActivity(intent);
                break;

        }
    }

    @Override
    public void onLoginButtonClick() {
        credentialsPresenter.getId(etLogin.getText().toString(), etPassword.getText().toString());

    }

    @Override
    public void openApplication(int id) {
        Intent intent = new Intent(this.getActivity(), UserActivity.class);
        //intent.putExtra("id", id);
        intent.putExtra("userId", id);
        intent.putExtra("fromRegistration", true);
        startActivity(intent);
    }

    @Override
    public void denyAccess() {
        Toast.makeText(this.getActivity(), "Wrong login or password", Toast.LENGTH_LONG).show();
    }

    @Override
    public void setId(int id) {

    }
}
