package com.TwoButtons.ilya.TwoButtons.Shared;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.android.ilya.TwoButtons.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFourFragment extends Fragment implements View.OnClickListener {

    Button[] headerButtons = new Button[4];
    float correction = (float) 0.06;

    int selected = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_four, null);

        Bundle args = getArguments();
        ArrayList<String> menuStrings = args.getStringArrayList("menuStrings");

        headerButtons[0] = view.findViewById(R.id.btnMenuFour1);
        headerButtons[1] = view.findViewById(R.id.btnMenuFour2);
        headerButtons[2] = view.findViewById(R.id.btnMenuFour3);
        headerButtons[3] = view.findViewById(R.id.btnMenuFour4);

        int sum = getSumValue(menuStrings);

        int minElement = getMinLengthElement(menuStrings);

        for (int i = 0; i < headerButtons.length; i++) {
            System.out.println(minElement);
            headerButtons[i].setOnClickListener(this);

            headerButtons[i].setText(menuStrings.get(i));
            headerButtons[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                    (((float)sum - (float)menuStrings.get(i).length())/(float)sum - (float) (i == minElement ? correction : -correction/3.0))));
        }

        setButtonsBackground(selected, 2);
        return view;
    }

    private int getSumValue(ArrayList<String> menuString){
        int sum = 0;

        for (String menu: menuString)
            sum += menu.length();

        return sum;
    }

    private int getMinLengthElement(ArrayList<String> menuString){
        int minLength = 100;
        int minNumber = 0;

        for (int i = 0; i < menuString.size(); i++) {
            if (menuString.get(i).length() < minLength) {
                minLength = menuString.get(i).length();
                minNumber = i;
            }
        }

        return minNumber;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnMenuFour1:
                buttonClicked(1);
                break;
            case R.id.btnMenuFour2:
                buttonClicked(2);
                break;
            case R.id.btnMenuFour3:
                buttonClicked(3);
                break;
            case R.id.btnMenuFour4:
                buttonClicked(4);
                break;
        }
    }

    private void buttonClicked(int number) {
        setButtonsBackground(number, selected);

        selected = number;

        MenuFourFragment.OnSelectedListListener listener = (MenuFourFragment.OnSelectedListListener) getActivity();
        listener.onListSelected(number);
    }

    private void setButtonsBackground(int selected, int previousSelected) {
        if (selected == previousSelected)
            return;

        headerButtons[selected-1].setTextColor(getResources().getColor(R.color.colorBlue));
        headerButtons[previousSelected-1].setTextColor(getResources().getColor(R.color.colorBlack));
    }

    public interface OnSelectedListListener {
        void onListSelected(int type);
    }
}
