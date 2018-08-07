package com.example.ilya.ourfuture.LoginPage;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ilya.ourfuture.R;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

public class NetworksFragment extends LoginFragment implements View.OnClickListener {

    private final String[] scope = new String[] {VKScope.FRIENDS, VKScope.EMAIL, VKScope.PHOTOS};

    LoginPresenter loginPresenter;

    ImageButton btnVk;
    TextView tvDontHaveNetworks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_networks, container, false);

        btnVk = view.findViewById(R.id.ibNetworksVk);
        tvDontHaveNetworks = view.findViewById(R.id.tvNetworksDontHaveNetworks);

        btnVk.setOnClickListener(this);
        tvDontHaveNetworks.setOnClickListener(this);

        loginPresenter = new NetworksPresenter(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ibNetworksVk:
                VKSdk.login(this, scope);
                break;
            case R.id.tvNetworksDontHaveNetworks:
                Intent intent = new Intent(this.getActivity(), MainActivity.class);
                this.startActivity(intent);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                System.out.println("AAAAA");
                System.out.println(res.userId);
                System.out.println(res.accessToken);
                System.out.println(res.httpsRequired);
                System.out.println(res.created);
                System.out.println(res.email);
                System.out.println(res.expiresIn);
                System.out.println(res.secret);

                ((NetworksPresenter)loginPresenter).vkLogin(res);
            }
            @Override
            public void onError(VKError error) {
                System.out.println("ERROR");
// Произошла ошибка авторизации (например, пользователь запретил авторизацию)
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
