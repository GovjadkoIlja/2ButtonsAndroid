package com.example.ilya.ourfuture.Markers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ilya.ourfuture.QuestionPage.Question;
import com.example.ilya.ourfuture.R;

import java.util.ArrayList;

/**
 * Created by Ilya on 07.03.2018.
 */

public class QuestionsAdapter extends ArrayAdapter<Question> implements View.OnClickListener { //Reorganize later Post and Question, to use one Adapter
    ArrayList<Question> questions;
    Context mContext;
    IQuestionsPresenter questionsPresenter;

    TextView tvLogin;
    TextView tvCondition;
    TextView tvType;
    TextView tvAnswers;
    TextView tvRaiting;
    TextView tvAskDate;
    ImageView ivAnswered;
    ImageView ivLiked;
    ImageView ivDisliked;

    public QuestionsAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull ArrayList<Question> _questions, IQuestionsPresenter _questionsPresenter) {
        super(context, resource, textViewResourceId, _questions);
        mContext = context;
        questions = _questions;
        questionsPresenter = _questionsPresenter;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // return super.getView(position, convertView, parent);

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.fragment_post, parent,
                false);

        tvLogin = row.findViewById(R.id.tvPostLogin);

        tvCondition = (TextView)row.findViewById(R.id.tvPostCondition);
        tvType = (TextView)row.findViewById(R.id.tvPostType);
        tvAnswers = (TextView)row.findViewById(R.id.tvPostAnswers);
        tvRaiting = (TextView)row.findViewById(R.id.tvPostRaiting);
        tvAskDate = (TextView)row.findViewById(R.id.tvPostAskDate);
        ivAnswered = (ImageView)row.findViewById(R.id.ivPostAnswered);
        ivLiked = (ImageView)row.findViewById(R.id.ivPostLike);
        ivDisliked = (ImageView)row.findViewById(R.id.ivPostDislike);
        /*tvCondition = (TextView)row.findViewById(R.id.tvQuestionsCondition);
        tvType = (TextView)row.findViewById(R.id.tvQuestionsType);
        tvAnswers = (TextView)row.findViewById(R.id.tvQuestionsAnswers);
        tvRaiting = (TextView)row.findViewById(R.id.tvQuestionsRaiting);
        tvAskDate = (TextView)row.findViewById(R.id.tvQuestionsAskDate);
        ivAnswered = (ImageView)row.findViewById(R.id.ivQuestionsAnswered);
        ivLiked = (ImageView)row.findViewById(R.id.ivQuestionsLike);
        ivDisliked = (ImageView)row.findViewById(R.id.ivQuestionsDislike);*/

        tvCondition.setOnClickListener(this);
        ivAnswered.setOnClickListener(this);

        representQuestion(questions.get(position));

        return row;
    }

    private void representQuestion(Question question) {

        tvLogin.setText(question.login);

        tvCondition.setText(question.condition);

        if (question.questionType == 0)
            tvType.setText("Анонимный");
        else
            tvType.setText("Открытый");

        tvAnswers.setText(question.answers + "");
        tvRaiting.setText(question.raiting + "");
        tvAskDate.setText(question.asked.substring(0, 10));

        if (question.answered == 1)
            ivAnswered.setImageResource(R.drawable.answered);

        if (question.yourFeedback == 1)
            ivLiked.setImageResource(R.drawable.liked);
        else if (question.yourFeedback == -1)
            ivDisliked.setImageResource(R.drawable.disliked);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.tvPostCondition):
            case (R.id.ivPostAnswered):
                View parentRow;
                parentRow = (View) view.getParent().getParent().getParent().getParent(); //dependency from the layout
                ListView listView = (ListView) parentRow.getParent();
                int position = listView.getPositionForView(parentRow);

                questionsPresenter.questionClicked(position, questions);

                //System.out.println(position);

                //peopleListPresenter.userSelected(people.get(position).userID);

                break;
        }
    }
}
