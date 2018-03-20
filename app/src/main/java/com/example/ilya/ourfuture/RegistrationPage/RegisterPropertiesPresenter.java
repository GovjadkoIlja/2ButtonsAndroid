package com.example.ilya.ourfuture.RegistrationPage;

import android.text.TextUtils;

import com.example.ilya.ourfuture.RegistrationPage.IRegisterPropertiesPresenter;
import com.example.ilya.ourfuture.RegistrationPage.IRegisterPropertiesView;
import com.example.ilya.ourfuture.RegistrationPage.RegisterPropertiesModel;
import com.example.ilya.ourfuture.Shared.Id;

/**
 * Created by Ilya on 08.01.2018.
 */

public class RegisterPropertiesPresenter implements IRegisterPropertiesPresenter {

    IRegisterPropertiesView registerPropertiesView;
    IRegisterPropertiesModel registerPropertiesModel;

    final int minPasswordLength = 8;

    boolean isLoginValid = true;

    public RegisterPropertiesPresenter(IRegisterPropertiesView _registerPropertiesView) {
        registerPropertiesView = _registerPropertiesView;
        registerPropertiesModel = new RegisterPropertiesModel(this);
    }

    public void register(String login, String password, String passwordRepeat, String phone, String description, String age, int sex) {
        boolean isOk = checkAll(login, password, passwordRepeat, phone, description, age, sex);
        if (isOk)
            registerPropertiesModel.doRegistration(login, password, phone, description, age, sex);
    }

    @Override
    public void registrationDone(int id) {
        if (id > 0) {
            Id.setId(id);
            registerPropertiesView.openApplication(id);
        }
        else if (id == -2) {
            registerPropertiesView.markLoginField(true);
            registerPropertiesView.wrongLoginManager(true);
        } else if (id == -1) {
            //If this phone already exists
        }

    }

    public boolean checkAll(String login, String password, String passwordRepeat, String phone, String description, String age, int sex) {
        boolean isOk = true;

        if (!isLoginValid) {
            isOk = false;
            registerPropertiesView.wrongLoginManager(true);
            registerPropertiesView.markLoginField(true);
        } else if (login.length() == 0) {
            isOk = false;
            registerPropertiesView.markLoginField(true);
        }

        if (!checkPassword(password) || password.length() == 0) {
            isOk = false;
            registerPropertiesView.markPasswordField(true);
        }

        if (!checkPasswordRepeat(password, passwordRepeat) || passwordRepeat.length() == 0) {
            isOk = false;
            registerPropertiesView.markPasswordRepeatField(true);
        }

        if (!checkAge(age) || age.length() == 0) {
            isOk = false;
            registerPropertiesView.markAgeField(true);
        }

        if (sex == -1) { //Doesn't chosen
            isOk = false;
            registerPropertiesView.markSexField(true);
        }

        return isOk;
    }

    public void checkLogin(String login) {
        registerPropertiesModel.checkLogin(login);
    }

    public void getLoginValidation(int isValid) {
        if (isValid == 1)
            isLoginValid = true;
        else
            isLoginValid = false;
        registerPropertiesView.wrongLoginManager(!isLoginValid);
    }

    public boolean checkPassword(String password) {
        boolean show = ((password.length() < minPasswordLength) && (password.length() > 0));
        registerPropertiesView.wrongPasswordManager(show);
        return !show;
    }

    public boolean checkPasswordRepeat(String password, String passwordRepeat) {
        boolean show = ((passwordRepeat.length() > 0) && (!password.equals(passwordRepeat)));
        registerPropertiesView.wrongPasswordRepeatManager(show);
        return !show;
    }

    public boolean checkAge(String strAge) {
        boolean show;
        if (strAge.length() == 0) {
            show = false;
            registerPropertiesView.wrongAgeManager(show);
            return !show;
        }
        int age = Integer.parseInt(strAge);
        show = (((age <= 0) || (age >= 100) || !TextUtils.isDigitsOnly(strAge)) && (strAge.length() > 0));
        registerPropertiesView.wrongAgeManager(show);
        return !show;
    }
}
