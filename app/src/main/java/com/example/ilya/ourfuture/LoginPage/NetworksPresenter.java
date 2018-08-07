package com.example.ilya.ourfuture.LoginPage;

import com.vk.sdk.VKAccessToken;

/**
 * Created by Ilya on 25.07.2018.
 */

public class NetworksPresenter extends LoginPresenter {

    public NetworksPresenter(NetworksFragment networksFragment) {
        loginFragment = networksFragment;
        loginModel = new NetworksModel(this);
    }

    public void vkLogin(VKAccessToken res) {
        ((NetworksModel)loginModel).vkLogin(res);
    }
}
