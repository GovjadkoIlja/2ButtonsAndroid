package com.example.ilya.ourfuture.CreateQuestion;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ilya.ourfuture.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateQuestionFurtherFragment extends Fragment implements View.OnClickListener {

    TextView tvFurther;
    ImageView ivFurtherArrow;
    RelativeLayout rlFurther;

    boolean isEnabled = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_question_further, container, false);

        rlFurther = view.findViewById(R.id.rlCreateQuestionFurther);
        tvFurther = view.findViewById(R.id.tvCreateQuestionFurter);
        ivFurtherArrow = view.findViewById(R.id.ivCreateQuestionFurtherArrow);

        Bundle args = getArguments();

        String furtherText = args.getString("buttonText");
        boolean showFurther = args.getBoolean("showFurter");
        boolean isEnabled = args.getBoolean("isEnabled", true);

        tvFurther.setText(furtherText);

        if (!showFurther)
            ivFurtherArrow.setVisibility(View.GONE);

        rlFurther.setOnClickListener(this);

        changeButtonState(isEnabled);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (!isEnabled)
            return;

        ButtonFurtherClicked listener = (ButtonFurtherClicked) getActivity();

        listener.further();

        /*String condition = listener.getCondition();
        ArrayList<String> options = listener.getOptions();

        Intent intent = new Intent(this.getActivity(), CreateQuestionSettingsActivity.class);

        intent.putExtra("condition", condition);
        intent.putExtra("options", options);

        startActivity(intent);*/
    }

    public void changeButtonState(boolean isEnabled) {
        this.isEnabled = isEnabled;

        if (isEnabled)
            rlFurther.setBackgroundColor(getResources().getColor(R.color.colorBlue));
        else
            rlFurther.setBackgroundColor(getResources().getColor(R.color.colorInactiveButton));
    }

    public interface ButtonFurtherClicked {
        /*String getCondition();
        ArrayList<String> getOptions();*/
        void further();
    }
}
