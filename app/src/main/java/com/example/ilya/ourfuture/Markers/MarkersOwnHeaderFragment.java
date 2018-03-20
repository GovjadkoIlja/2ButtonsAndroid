package com.example.ilya.ourfuture.Markers;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ilya.ourfuture.R;

public class MarkersOwnHeaderFragment extends Fragment implements IMarkersOwnHeaderFragment, View.OnClickListener {

    IMarkersOwnHeaderPresenter markersOwnHeaderPresenter;

    final int defaultSelected = 1;
    int selected = 1;

    Button btnMy;
    Button btnFavorites;
    Button btnHistory;
    Button btnBest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_markers_own_header, null);

        markersOwnHeaderPresenter = new MarkersOwnHeaderPresenter(this);

        btnMy = view.findViewById(R.id.btnMarkersHeaderMine);
        btnFavorites = view.findViewById(R.id.btnMarkersHeaderFavorites);
        btnHistory = view.findViewById(R.id.btnMarkersHeaderHistory);
        btnBest = view.findViewById(R.id.btnMarkersHeaderBest);

        btnMy.setOnClickListener(this);
        btnFavorites.setOnClickListener(this);
        btnHistory.setOnClickListener(this);
        btnBest.setOnClickListener(this);

        buttonClicked(defaultSelected);

        return view;
    }

    @Override
    public void setButtons(int newSelected) {
        for (int i = 1; i <= 4; i++) {
            if ((i == selected) || (i == newSelected)) //To don't update an interface without any purpose
                setButton(getButtonByNumber(i), i == newSelected);
        }

        selected = newSelected;
    }

    private void setButton(Button btn, boolean isSelected) {
        if (isSelected) {
            btn.setBackgroundColor(getResources().getColor(R.color.colorBlue));
            btn.setTextColor(getResources().getColor(R.color.colorWhite));
        } else {
            btn.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            btn.setTextColor(getResources().getColor(R.color.colorBlue));
        }
    }

    private Button getButtonByNumber(int number) {
        switch (number) {
            case 1:
                return btnMy;
            case 2:
                return btnFavorites;
            case 3:
                return btnHistory;
            case 4:
                return btnBest;
        }

        return btnMy;
    }

    @Override
    public void onClick(View view) {
        int number = 0;
        switch (view.getId()) {
            case R.id.btnMarkersHeaderMine:
                number = 1;
                break;
            case R.id.btnMarkersHeaderFavorites:
                number = 2;
                break;
            case R.id.btnMarkersHeaderHistory:
                number = 3;
                break;
            case R.id.btnMarkersHeaderBest:
                number = 4;
                break;
        }

        if (number != selected) //change it only if we clicked to the new button
            buttonClicked(number);
    }

    private void buttonClicked(int number) {
        markersOwnHeaderPresenter.buttonClicked(number);

        MarkersOwnHeaderFragment.OnSelectedListListener listener = (MarkersOwnHeaderFragment.OnSelectedListListener) getActivity();
        listener.onListSelected(number);
    }

    public interface OnSelectedListListener {
        void onListSelected(int type);
    }
}
