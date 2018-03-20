package com.example.ilya.ourfuture;

import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class CreateQuestionFirstFragment extends Fragment {

    TextView tvHeader;
    TextView tvSymbols;
    EditText etText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_question_first, null);

        tvHeader = view.findViewById(R.id.tvCreateQuestionHeader);
        tvSymbols = view.findViewById(R.id.tvCreateQuestionSymbols);
        etText = view.findViewById(R.id.etCreateQuestionText);

        Bundle args = getArguments();

        int maxLength= args.getInt("maxLength");
        String header = args.getString("header");
        String defaultText = args.getString("defaultText");

        tvHeader.setText(header);

        etText.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setSymbols(charSequence.length(), maxLength);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        return view;
    }

    private void setSymbols(int length, int maxLength) {
        tvSymbols.setText(length + "/" + maxLength);
    }

}
