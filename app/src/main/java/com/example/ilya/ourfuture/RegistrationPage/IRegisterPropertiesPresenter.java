package com.example.ilya.ourfuture.RegistrationPage;

/**
 * Created by Ilya on 08.01.2018.
 */

public interface IRegisterPropertiesPresenter {
    void register(String login, String password, String passwordRepeat, String phone, String email, String age, int sex);
    void registrationDone(int id);
    boolean checkAll(String login, String password, String passwordRepeat, String phone, String email, String age, int sex);
    void checkLogin(String login);
    void getLoginValidation(int isValid);
    boolean checkPassword(String password);
    boolean checkPasswordRepeat(String passwordOriginal, String passwordRepeat);
    boolean checkAge(String age);
}
