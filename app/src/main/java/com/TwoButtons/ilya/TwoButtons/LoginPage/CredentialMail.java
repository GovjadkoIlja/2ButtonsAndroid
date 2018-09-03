package com.TwoButtons.ilya.TwoButtons.LoginPage;

/**
 * Created by Ilya on 28.08.2018.
 */

public class CredentialMail extends Credentials {
    String email;

    public CredentialMail(String email, String password) {
        this.email = email;
        this.password = password;
        this.grantType = 2;
    }
}
