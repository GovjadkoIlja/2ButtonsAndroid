package com.example.ilya.ourfuture.LoginPage;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.PreferencesNames;
import com.example.ilya.ourfuture.UserPage.UserActivity;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Ilya on 25.07.2018.
 */

public abstract class LoginFragment extends Fragment {
    public void openApplication(int id, String login) {
        Intent intent;

        intent = new Intent(getActivity(), UserActivity.class);
        //intent.putExtra("id", id);
        intent.putExtra("userId", id);
        intent.putExtra("userLogin", login);
        intent.putExtra("fromRegistration", true);
        startActivity(intent);
    }

    public void denyAccess() {
        Toast.makeText(this.getActivity(), "Wrong login or password", Toast.LENGTH_LONG).show();
    }

    public void saveCredentials() {
        SharedPreferences sPref = getActivity().getSharedPreferences("loginPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();

        ed.putInt(PreferencesNames.userId, Id.id);
        ed.putString(PreferencesNames.smallAvatarLink, Id.smallAvatarLink);
        ed.putString(PreferencesNames.login, Id.login);
        ed.putString(PreferencesNames.accessToken, Id.accessToken);
        ed.putString(PreferencesNames.refreshToken, Id.refreshToken);
        ed.putInt(PreferencesNames.roleType, Id.roleType);

        ed.apply();
        //Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }
}
