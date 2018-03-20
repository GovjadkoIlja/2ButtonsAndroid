package com.example.ilya.ourfuture.Markers;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ilya.ourfuture.R;

public class MarkersQuestionTypeFragment extends Fragment implements View.OnClickListener {

    boolean isAll = true;

    Button btnAll;
    Button btnNew;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_markers_question_type, null);

        btnAll = view.findViewById(R.id.btnMarkersAll);
        btnNew = view.findViewById(R.id.btnMarkersNew);

        btnAll.setOnClickListener(this);
        btnNew.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        isAll = !isAll;
        setButtons(isAll);
    }

    private void setButtons(boolean _isAll) {
        setButton(btnAll, _isAll);
        setButton(btnNew, !_isAll);
    }

    private void setButton(Button btn, boolean isOn) {
        if (isOn) {
            btn.setBackgroundColor(getResources().getColor(R.color.colorBlue));
            btn.setTextColor(getResources().getColor(R.color.colorWhite));
        } else {
            btn.setBackgroundColor(getResources().getColor(R.color.colorLightGrey));
            btn.setTextColor(getResources().getColor(R.color.colorAnsweredOptionText));
        }
    }
}
