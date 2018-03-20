package com.example.ilya.ourfuture.UserPage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ilya.ourfuture.QuestionPage.QuestionActivity;
import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.Id;

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

        postsPresenter.sinchronizeWithQuestions();
    }

    @Override
    public void representPosts(List<Post> posts) {
        PostsAdapter adapter = new PostsAdapter(getActivity(), R.layout.fragment_post, R.layout.fragment_post, posts, postsPresenter);
        setListAdapter(adapter);
    }

    @Override
    public void openQuestion(int id) {
        Intent intent = new Intent(this.getActivity(), QuestionActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}

