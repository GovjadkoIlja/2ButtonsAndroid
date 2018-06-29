package com.example.ilya.ourfuture.QuestionPage;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Question.Question;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionHeaderFragment extends Fragment implements IQuestionHeaderView, View.OnClickListener {

    IQuestionHeaderPresenter questionHeaderPresenter;

    TextView tvLogin;
    TextView tvType;
    TextView tvRaiting;
    ImageButton ibLike;
    ImageButton ibDislike;
    ImageButton ibFavorites;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_header, null);

        Bundle args = getArguments();

        int position = args.getInt("position");
        ArrayList<Question> questions = (ArrayList<Question>) args.getSerializable("questions");

        tvLogin = view.findViewById(R.id.tvQuestionAsker);
        tvType = view.findViewById(R.id.tvQuestionType);
        tvRaiting = view.findViewById(R.id.tvQuestionRaiting);
        ibLike = view.findViewById(R.id.ibQuestionLike);
        ibDislike = view.findViewById(R.id.ibQuestionDislike);
        ibFavorites = view.findViewById(R.id.ibQuestionFavorite);

        ibLike.setOnClickListener(this);
        ibDislike.setOnClickListener(this);
        ibFavorites.setOnClickListener(this);

        questionHeaderPresenter = new QuestionHeaderPresenter(position, questions, this);

        //questionHeaderPresenter.getQuestion();

        return view;
    }

    @Override
    public void fillLogin(String login) {
        tvLogin.setText(login);
    }

    @Override
    public void fillQuestionType(String type) {
        tvType.setText(type);
    }

    @Override
    public void setRaiting(String raiting) {
        tvRaiting.setText(raiting);
    }

    @Override
    public void setFeedback(boolean isLiked, boolean isDisliked) {
        if (isLiked) {
            ibLike.setImageResource(R.drawable.liked);
            ibDislike.setImageResource(R.drawable.thumb_down);
        }
        else if (isDisliked) {
            ibDislike.setImageResource(R.drawable.disliked);
            ibLike.setImageResource(R.drawable.thumb_up);
        } else {
            ibLike.setImageResource(R.drawable.thumb_up);
            ibDislike.setImageResource(R.drawable.thumb_down);
        }
    }

    @Override
    public void setFavorites(boolean inFavorites) {
        if (inFavorites)
            ibFavorites.setImageResource(R.drawable.favorite);
        else
            ibFavorites.setImageResource(R.drawable.star);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.ibQuestionLike):
                questionHeaderPresenter.feedbackChanged(true);
                break;
            case (R.id.ibQuestionDislike):
                questionHeaderPresenter.feedbackChanged(false);
                break;
            case (R.id.ibQuestionFavorite):
                questionHeaderPresenter.favoritesChanged();
        }
    }
}
