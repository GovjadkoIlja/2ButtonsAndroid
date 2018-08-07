package com.example.ilya.ourfuture.Shared;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ilya.ourfuture.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ErrorFragment extends Fragment {

    final String serverErrorDescription = "Произошла ошибка :(\n Мы уже исправляем ее :)";
    final String noInternetDescription = "Пожалуйста, проверьте свое соединение с Интернетом и повторите попытку";
    final String emptyListDescription = "Этот список пока пуст";

    ImageView ivErrorIcon;
    TextView tvErrorDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_error, container, false);

        Bundle bundle = getArguments();

        int errorType = bundle.getInt("errorType", 1);

        ivErrorIcon = view.findViewById(R.id.ivErrorIcon);
        tvErrorDescription = view.findViewById(R.id.tvErrorDescription);

        setError(errorType);

        return view;
    }

    public void setError(int errorType) {
        switch (errorType) {
            case 1:
                ivErrorIcon.setImageResource(R.drawable.server_error);
                tvErrorDescription.setText(serverErrorDescription);
                break;

            case 2:
                ivErrorIcon.setImageResource(R.drawable.no_internet_error);
                tvErrorDescription.setText(noInternetDescription);
                break;

            case 3:
                ivErrorIcon.setImageResource(R.drawable.list_is_empty);
                tvErrorDescription.setText(emptyListDescription);
                break;
        }
    }

}
