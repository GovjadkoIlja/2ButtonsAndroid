package com.TwoButtons.ilya.TwoButtons.UserPage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.ilya.TwoButtons.R;

/**
 * Created by Ilya on 24.06.2018.
 */

public class UserButton extends LinearLayout {
    View rootView;
    TextView tvDescription;
    TextView tvValue;

    public UserButton(Context context) {
        super(context);
        init(context);
    }

    public UserButton(Context context, AttributeSet attr) {
        super(context, attr);
        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.user_button, this);
        tvDescription = rootView.findViewById(R.id.tvUserButtonDescription);
        tvValue = rootView.findViewById(R.id.tvUserButtonValue);
    }

    public void setDescription(String description) {
        tvDescription.setText(description);
    }

    public void setValue(int value) {
        tvValue.setText(value + "");
    }
}
