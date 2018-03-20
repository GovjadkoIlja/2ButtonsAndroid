package com.example.ilya.ourfuture.LoginPage;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.HeaderFragment;

public class MainActivity extends AppCompatActivity /*implements HeaderFragment.FragmentListener*/ {

    String header = "Вход в OurFuture";
    boolean showBack = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle headerArgs = new Bundle();
        headerArgs.putString("headerText", header);
        headerArgs.putBoolean("showBack", showBack);

        Fragment headerFragment = new HeaderFragment();
        headerFragment.setArguments(headerArgs);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.loginFrameHeader, headerFragment);
        ft.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        /*Fragment header = getFragmentManager().findFragmentById(R.id.fragmentHeader1);
        TextView etHeader = (TextView)header.getView().findViewById(R.id.tvHeader);
        etHeader.setText("ПРИВЕТ!");*/
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
