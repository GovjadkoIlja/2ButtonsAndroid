package com.example.ilya.ourfuture.RegistrationPage;

/**
 * Created by Ilya on 08.01.2018.
 */

public interface IRegisterPropertiesView {
    void buttonRegisterClicked();
    void wrongLoginManager(boolean show);
    void wrongPasswordManager(boolean show);
    void wrongPasswordRepeatManager(boolean show);
    void wrongAgeManager(boolean show);
    void markLoginField(boolean isWrong);
    void markPasswordField(boolean isWrong);
    void markPasswordRepeatField(boolean isWrong);
    void markAgeField(boolean isWrong);
    void markSexField(boolean isWrong);
    void openApplication(int id);
}
