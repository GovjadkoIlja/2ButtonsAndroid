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

        tvFurther.setText(furtherText);

        if (!showFurther)
            ivFurtherArrow.setVisibility(View.GONE);

        rlFurther.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        ButtonFurtherClicked listener = (ButtonFurtherClicked) getActivity();

        listener.further();

        /*String condition = listener.getCondition();
        ArrayList<String> options = listener.getOptions();

        Intent intent = new Intent(this.getActivity(), CreateQuestionSettingsActivity.class);

        intent.putExtra("condition", condition);
        intent.putExtra("options", options);

        startActivity(intent);*/
    }

    public interface ButtonFurtherClicked {
        /*String getCondition();
        ArrayList<String> getOptions();*/
        void further();
    }
}
