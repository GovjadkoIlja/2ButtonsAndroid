package com.example.ilya.ourfuture.LoginPage;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.RegistrationPage.RegisterActivity;
import com.example.ilya.ourfuture.UserPage.UserActivity;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;
import com.vk.sdk.util.VKUtil;

public class CredentialsFragment extends LoginFragment implements ICredentialsView, View.OnClickListener {

    private final String loginHint = "Email или телефон";
    private final String passwordHint = "Пароль";

    private final String[] scope = new String[] {VKScope.FRIENDS, VKScope.EMAIL, VKScope.PHOTOS};

    Button btnLogin;
    //Button btnRegister;
    TextView tvRegister;
    CredentialsEditText etLogin;
    CredentialsEditText etPassword;

    ICredentialsPresenter credentialsPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_credentials, null);

        etLogin = view.findViewById(R.id.etLogin);
        etPassword = view.findViewById(R.id.etPassword);
        btnLogin = view.findViewById(R.id.btnLogin);
        tvRegister = view.findViewById(R.id.tvCredentialsRegister);

        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);

        if (credentialsPresenter == null) {
            credentialsPresenter = new CredentialsPresenter(this);
        }

        etLogin.setHint(loginHint);
        etPassword.setHint(passwordHint);

        etLogin.setText("89046401133");
        etPassword.setText("Hash");

        etPassword.setTextType(true);

        /*String[] fingerprints = VKUtil.getCertificateFingerprint(this.getActivity(), this.toString());

        System.out.println(fingerprints);
        System.out.println("AAAAAAAAA");*/

        //VKSdk.login(this, scope);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.btnLogin):
                onLoginButtonClick();
                break;
            case (R.id.tvCredentialsRegister):
                Intent intent = new Intent(this.getActivity(), RegisterActivity.class);
                startActivity(intent);
                break;

        }
    }

    @Override
    public void onLoginButtonClick() {
        credentialsPresenter.getId(etLogin.getText(), etPassword.getText());

    }
}
