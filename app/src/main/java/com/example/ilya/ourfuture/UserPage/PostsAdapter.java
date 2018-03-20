package com.example.ilya.ourfuture.UserPage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ilya.ourfuture.R;

import java.util.List;

public class PostsAdapter extends ArrayAdapter<Post> implements View.OnClickListener {

    List<Post> posts;
    Context mContext;
    IPostsPresenter postsPresenter;

    TextView tvLogin;
    TextView tvDate;
    TextView tvCondition;
    TextView tvAction;
    TextView tvType;
    TextView tvAnswers;
    TextView tvRaiting;
    TextView tvAskDate;
    ImageView ivAnswered;
    ImageView ivLiked;
    ImageView ivDisliked;

    public PostsAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Post> _posts, IPostsPresenter _postsPresenter) {
        super(context, resource, textViewResourceId, _posts);
        mContext = context;
        posts = _posts;
        postsPresenter = _postsPresenter;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // return super.getView(position, convertView, parent);

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.fragment_post, parent,
                false);

        tvLogin = (TextView)row.findViewById(R.id.tvPostLogin);
        tvAction = (TextView)row.findViewById(R.id.tvPostAction);
        tvDate = (TextView)row.findViewById(R.id.tvPostDate);
        tvCondition = (TextView)row.findViewById(R.id.tvPostCondition);
        tvType = (TextView)row.findViewById(R.id.tvPostType);
        tvAnswers = (TextView)row.findViewById(R.id.tvPostAnswers);
        tvRaiting = (TextView)row.findViewById(R.id.tvPostRaiting);
        tvAskDate = (TextView)row.findViewById(R.id.tvPostAskDate);
        ivAnswered = (ImageView)row.findViewById(R.id.ivPostAnswered);
        ivLiked = (ImageView)row.findViewById(R.id.ivPostLike);
        ivDisliked = (ImageView)row.findViewById(R.id.ivPostDislike);

        tvCondition.setOnClickListener(this);
        ivAnswered.setOnClickListener(this);

        representPost(posts.get(position));

        return row;
    }

    private void representPost(Post post) {
        tvLogin.setText(post.login);

        if (postsPresenter.getPageOwnerId() == post.avatarUserID)
            tvAction.setText("спросил:");
        else
            tvAction.setText("поделился:");

        tvDate.setText(post.posted.substring(0, 10));
        tvCondition.setText(post.condition);

        if (post.questionType == 0)
            tvType.setText("Анонимный");
        else
            tvType.setText("Открытый");

        tvAnswers.setText(post.anwsers + "");
        tvRaiting.setText(post.raiting + "");
        tvAskDate.setText(post.asked.substring(0, 10));

        if (post.anwsered == 1)
            ivAnswered.setImageResource(R.drawable.answered);

        if (post.yourFeedback == 1)
            ivLiked.setImageResource(R.drawable.liked);
        else if (post.yourFeedback == -1)
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

                postsPresenter.questionClicked(position, posts);

                //System.out.println(position);

                //peopleListPresenter.userSelected(people.get(position).userID);

                break;
        }
    }
}
