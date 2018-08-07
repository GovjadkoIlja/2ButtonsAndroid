package com.example.ilya.ourfuture.UsersList;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.ilya.ourfuture.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserListSearchFragment extends Fragment implements IPeopleSearchView {

    EditText etSearch;
    ImageButton btnErase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_people_search, container, false);

        etSearch = view.findViewById(R.id.etPeopleSearchText);
        btnErase = view.findViewById(R.id.btnPeopleSearchErase);

        btnErase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etSearch.setText("");
            }
        });

        /*etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                peopleSearchPresenter.searchTextChanged(etSearch.getText().toString());
            }
        });*/

        return view;
    }

    @Override
    public void changeEraseButtonVisibility(boolean show) {
        if (show)
            btnErase.setVisibility(View.VISIBLE);
        else
            btnErase.setVisibility(View.GONE);
    }
}
