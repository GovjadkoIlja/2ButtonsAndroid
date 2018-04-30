package com.example.ilya.ourfuture.UserPage;

import android.content.Intent;
import android.os.Bundle;
import android.app.ListFragment;

import com.example.ilya.ourfuture.QuestionPage.QuestionActivity;
import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.Question;
import com.example.ilya.ourfuture.Shared.QuestionsAdapter;
import com.example.ilya.ourfuture.Shared.QuestionsListPresenter;

import java.util.ArrayList;
import java.util.List;

public class PostsFragment extends ListFragment implements IPostsView {

    IPostsPresenter postsPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();

        int userId = args.getInt("userId", Id.getId());

        postsPresenter = new PostsPresenter(userId, this);

        postsPresenter.receivePosts(userId);
    }

    @Override
    public void onResume() {
        super.onResume();

        //postsPresenter.sinchronizeWithQuestions();
    }

    @Override
    public void representPosts(ArrayList<Question> questions) {
        QuestionsAdapter adapter = new QuestionsAdapter(getActivity(), R.layout.fragment_post, R.layout.fragment_post, questions, (QuestionsListPresenter) postsPresenter);
        setListAdapter(adapter);
    }

    @Override
    public void openQuestion(int id, int position, ArrayList<Question> questions) {
        Intent intent = new Intent(this.getActivity(), QuestionActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("position", position);
        intent.putExtra("questions", questions);
        startActivity(intent);
    }
}

