package com.example.ilya.ourfuture.LoginPage;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.PreferencesNames;
import com.example.ilya.ourfuture.UserPage.UserActivity;
import com.vk.sdk.util.VKUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class NetworksActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_networks);

        /*String[] fingerprints = VKUtil.getCertificateFingerprint(this, this.getPackageName());
        System.out.println(Arrays.asList(fingerprints));
        System.out.println("PRINTS");
        System.out.println("1A7119D7D914089172B75BABC622B8FFA89C1D08");*/

        if (isLogedIn())
            openApplication(Id.getId(), Id.getLogin());

        Fragment networksFragment = new NetworksFragment();
        FragmentTransaction networksTransaction = getFragmentManager().beginTransaction();
        networksTransaction.add(R.id.networksFrameNetworks, networksFragment);
        networksTransaction.commit();
    }

    private void openApplication(int id, String login) {
        Intent intent;

        intent = new Intent(this, UserActivity.class);
        //intent.putExtra("id", id);
        intent.putExtra("userId", id);
        intent.putExtra("userLogin", login);
        intent.putExtra("fromRegistration", true);
        startActivity(intent);
    }

    private boolean isLogedIn() {
        SharedPreferences sPref = getSharedPreferences("loginPref" , MODE_PRIVATE);

        int userId = sPref.getInt(PreferencesNames.userId, 0);

        if (userId == 0)
            return false;

        String smallAvatarLink = sPref.getString(PreferencesNames.smallAvatarLink, "");
        String login = sPref.getString(PreferencesNames.login, "");
        String accessToken = sPref.getString(PreferencesNames.accessToken, "");
        String refreshToken = sPref.getString(PreferencesNames.refreshToken, "");
        int roleType = sPref.getInt(PreferencesNames.roleType, 1);

        //sPref.edit().clear().apply();

        new Id(userId, smallAvatarLink, login, accessToken, refreshToken, roleType);

        return true;
    }
}
