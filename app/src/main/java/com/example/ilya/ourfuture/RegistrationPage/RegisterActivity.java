package com.example.ilya.ourfuture.RegistrationPage;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ilya.ourfuture.Shared.HeaderFragment;
import com.example.ilya.ourfuture.R;

public class RegisterActivity extends AppCompatActivity {

    String header = "Регистрация";
    boolean showBack = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Bundle headerArgs = new Bundle();
        headerArgs.putString("headerText", header);
        headerArgs.putBoolean("showBack", showBack);

        Fragment headerFragment = new HeaderFragment();
        headerFragment.setArguments(headerArgs);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.registerFrameHeader, headerFragment);
        ft.commit();
    }

    /*@Override
    public String getHeaderText() {
        return header;
    }

    @Override
    public boolean showButtonBack() {
        return showBack;
    }*/
}
