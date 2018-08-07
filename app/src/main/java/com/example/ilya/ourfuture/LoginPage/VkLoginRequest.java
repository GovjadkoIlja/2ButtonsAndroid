package com.example.ilya.ourfuture.LoginPage;

import com.vk.sdk.VKAccessToken;

/**
 * Created by Ilya on 25.07.2018.
 */

public class VkLoginRequest {
    String state;
    int socialType;
    int externalUserId;
    String accessToken;
    String created;
    String email;
    int expiresIn;
    boolean isHttpsRequired;
    String secret;

    public VkLoginRequest(VKAccessToken res) {
        externalUserId = Integer.parseInt(res.userId);
        accessToken = res.accessToken;
        isHttpsRequired = res.httpsRequired;
        created = res.created + "";
        email = res.email;
        expiresIn = res.expiresIn;
        secret = res.secret;
        socialType = 2;
        state = "S5ocialCode!129_Code";
    }
}
