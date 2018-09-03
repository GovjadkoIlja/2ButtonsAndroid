package com.TwoButtons.ilya.TwoButtons.Voters;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.ilya.TwoButtons.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class VotersMenuFragment extends Fragment implements View.OnClickListener {

    final int maxLength = 25;
    int selected;

    MenuItem miFirstOption;
    MenuItem miSecondOption;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_voters_menu, container, false);

        miFirstOption = view.findViewById(R.id.miVotersFirstOption);
        miSecondOption = view.findViewById(R.id.miVotersSecondOption);

        Bundle args = getArguments();

        ArrayList<String> options = args.getStringArrayList("options");
        int selected = args.getInt("option");

        setSelectedOption(selected);

        String cut;

        for (int i = 0; i < options.size(); i++) {
            cut = cutString(options.get(i));
            options.set(i, cut);
        }

        miFirstOption.setText(options.get(0));
        miSecondOption.setText(options.get(1));

        miFirstOption.setOnClickListener(this);
        miSecondOption.setOnClickListener(this);

        return view;
    }

    private String cutString(String full) {
        String cut;

        if (full.length() > maxLength - 1) {
            cut = full.substring(0, maxLength - 4);
            cut = cut + "...";
            return cut;
        }

        return full;
    }

    @Override
    public void onClick(View view) {
        int newSelected = 1;

        switch (view.getId()) {
            case R.id.miVotersFirstOption:
                newSelected = 1;
                break;
            case R.id.miVotersSecondOption:
                newSelected = 2;
                break;
        }

        if (newSelected != selected) {
            setSelectedOption(newSelected);

            SelectedOptions selectedOptions = (SelectedOptions) getActivity();
            selectedOptions.selectedOptionChanged(newSelected);
        }
    }

    private void setSelectedOption(int selected) {
        this.selected = selected;
        if (selected == 1) {
            miFirstOption.setSelected(true);
            miSecondOption.setSelected(false);
        } else {
            miFirstOption.setSelected(false);
            miSecondOption.setSelected(true);
        }
    }

    public interface SelectedOptions {
        void selectedOptionChanged(int selected);
    }
}
