package com.example.ilya.ourfuture.News;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.ilya.ourfuture.R;

import java.util.ArrayList;

/**
 * Created by Ilya on 03.07.2018.
 */

public class NewsQuestionsAdapter extends ArrayAdapter<NewsQuestion> {
    ArrayList<NewsQuestion> questions;
    Context mContext;
    NewsQuestionView newsQuestionView;
    NewsQuestionsFragment newsQuestionsFragment;

    public NewsQuestionsAdapter(@NonNull Context context, int resource, int textViewResourceId,
                            @NonNull ArrayList<NewsQuestion> _questions, NewsQuestionsFragment newsQuestionsFragment) {
        super(context, resource, textViewResourceId, _questions);
        mContext = context;
        questions = _questions;
        this.newsQuestionsFragment = newsQuestionsFragment;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.fragment_newsquestion, parent,
                false);

        newsQuestionView = row.findViewById(R.id.newsQuestion);

        newsQuestionView.representQuestion(questions.get(position));

        if (position == questions.size() - 3) {
            newsQuestionsFragment.getNewQuestionsSet();
        }

        return row;
    }

    /*private void representQuestion(NewsQuestion question) {
        newsQuestionView.representQuestion(question);
        ///newsQuestionView.setDescription(question);
    }*/
}
