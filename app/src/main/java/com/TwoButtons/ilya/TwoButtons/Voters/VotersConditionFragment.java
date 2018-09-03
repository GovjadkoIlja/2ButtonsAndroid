package com.TwoButtons.ilya.TwoButtons.Voters;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.ilya.TwoButtons.R;

public class VotersConditionFragment extends Fragment {

    TextView tvCondition;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_voters_condition, container, false);

        tvCondition = view.findViewById(R.id.tvVotersCondition);

        Bundle args = getArguments();

        String condition = args.getString("condition");

        tvCondition.setText(condition);

        return view;
    }

}
