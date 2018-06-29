package com.example.ilya.ourfuture.CreateQuestion;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ilya.ourfuture.R;

/**
 * Created by Ilya on 23.06.2018.
 */

public class SettingsItem extends LinearLayout implements View.OnClickListener {
    View rootView;
    TextView tvDescription;
    ImageView ivCheck;

    boolean isEnabled;

    public SettingsItem(Context context) {
        super(context);
        init(context);
    }

    public SettingsItem(Context context, AttributeSet attr) {
        super(context, attr);
        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.settings_item, this);

        tvDescription = rootView.findViewById(R.id.tvCreateQuestionSettingsDescription);
        ivCheck = rootView.findViewById(R.id.ivCreateQuestionSettingsCheck);

        rootView.setOnClickListener(this);
    }

    public void setData(String description, boolean isEnabled) {
        tvDescription.setText(description);
        this.isEnabled = isEnabled;

        setCheck(isEnabled);
    }

    public void setCheck(boolean isEnabled) {
        if (isEnabled)
            ivCheck.setImageResource(R.drawable.setting_check_enabled);
        else
            ivCheck.setImageResource(R.drawable.setting_check);
    }

    public boolean getStatus() {
        return isEnabled;
    }

    @Override
    public void onClick(View view) {
        isEnabled = !isEnabled;

        setCheck(isEnabled);
    }
}
