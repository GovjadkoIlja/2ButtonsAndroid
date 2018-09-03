package com.TwoButtons.ilya.TwoButtons.Voters;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.ilya.TwoButtons.R;

/**
 * Created by Ilya on 30.06.2018.
 */

public class MenuItem extends LinearLayout {

    View rootView;
    RelativeLayout rlMenuItem;
    TextView tvMenuItemText;
    LinearLayout llUnderline;

    boolean isSelected;

    public MenuItem(Context context) {
        super(context);
        init(context);
    }

    public MenuItem(Context context, AttributeSet attr) {
        super(context, attr);
        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.menu_item, this);

        rlMenuItem = rootView.findViewById(R.id.rlMenuItem);
        tvMenuItemText = rootView.findViewById(R.id.tvMenuItemText);
        llUnderline = rootView.findViewById(R.id.llUnderlineMenuItem);
    }

    public void setText(String text) {
        tvMenuItemText.setText(text);
    }

    public void setSelected(boolean isSelected) {
        if (isSelected) {
            tvMenuItemText.setTextColor(getResources().getColor(R.color.colorBlue));
            llUnderline.setBackgroundColor(getResources().getColor(R.color.colorBlue));
        } else {
            tvMenuItemText.setTextColor(getResources().getColor(R.color.colorBlack));
            llUnderline.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        }
    }
}
