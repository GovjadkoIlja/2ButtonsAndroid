package com.example.ilya.ourfuture.Shared;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ilya.ourfuture.LoginPage.MainActivity;
import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.UserPage.UserActivity;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeaderFragment extends Fragment implements View.OnClickListener {

    ImageButton btnBack;
    TextView tvHeader;
    //TextView tvHelp;
    ImageButton ibMyPage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_header, null);

        btnBack = view.findViewById(R.id.btnBack);
        tvHeader = view.findViewById(R.id.tvHeader);
        ibMyPage = view.findViewById(R.id.ibHeaderMyPage);
        //tvHelp = view.findViewById(R.id.tvHeaderHelp);

        ibMyPage.setOnClickListener(this);

        Bundle args = getArguments();

        tvHeader.setText(args.getString("headerText", ""));

        //String helpText = args.getString("headerHelpText", "");

        /*if (helpText.equals(""))
            tvHelp.setVisibility(View.GONE);
        else
            tvHelp.setText(helpText);*/

        if (args.getBoolean("showBack", true)) {
            btnBack.setOnClickListener(this);
            btnBack.setVisibility(View.VISIBLE);
        } else
            btnBack.setVisibility(View.INVISIBLE);

        return view;
    }

    /*@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mListener = (FragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement FragmentListener");
        }

        headerText = mListener.getHeaderText();

        if (activity.getClass() == MainActivity.class)
            showBack = false;

        //showBack = mListener.showButtonBack();

    }*/

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.btnBack):
                this.getActivity().onBackPressed();
                break;
            case (R.id.ibHeaderMyPage):
                Intent intent = new Intent(this.getActivity(), UserActivity.class);
                intent.putExtra("userId", Id.getId());
                startActivity(intent);
                break;
        }
    }
}
