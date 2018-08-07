package com.example.ilya.ourfuture.UsersList;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.ImagesDownload;
import com.example.ilya.ourfuture.UserPage.UserActivity;
import com.squareup.picasso.Picasso;

/**
 * Created by Ilya on 26.06.2018.
 */

public class UserItem extends LinearLayout implements View.OnClickListener {
    final String youFollowedText = "Вы подписаны";
    final String followText = "Подписаться";

    UserItemPresenter userItemPresenter;
    UsersListFragment usersListFragment;

    View rootView;
    ImageView ivPhoto;
    TextView tvLogin;
    Button btnFollow;

    public UserItem(Context context) {
        super(context);
        init(context);
    }

    public UserItem(Context context, AttributeSet attr) {
        super(context, attr);
        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.user_item, this);
        ivPhoto = rootView.findViewById(R.id.ivUserItemPhoto);
        tvLogin = rootView.findViewById(R.id.tvUserItemLogin);
        btnFollow = rootView.findViewById(R.id.btnUserItemSubscribe);

        rootView.setOnClickListener(this);
        ivPhoto.setOnClickListener(this);
        btnFollow.setOnClickListener(this);
    }

    public void setData(Person person, UsersListFragment usersListFragment) {
        this.usersListFragment = usersListFragment;
        userItemPresenter = new UserItemPresenter(this, person);
        userItemPresenter.savePerson(person);
    }

    public void representPerson(String login) {
        tvLogin.setText(login);
    }

    public void setSubscribeButton(int userId, boolean isYouFollowed) {
        if (userId == Id.getId()) {
            btnFollow.setVisibility(INVISIBLE);
            return;
        }

        if (isYouFollowed) {
            btnFollow.setText(youFollowedText);
            btnFollow.setBackground(getResources().getDrawable(R.drawable.button_you_subscribed));
            btnFollow.setTextColor(getResources().getColor(R.color.colorBlack));
        } else {
            btnFollow.setText(followText);
            btnFollow.setBackground(getResources().getDrawable(R.drawable.button_subscribe));
            btnFollow.setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    public void setPhoto(String url) {
        ImagesDownload.setCircleImage(url, ivPhoto);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnUserItemSubscribe)
            userItemPresenter.subscribeButtonClicked();
        else {
            Intent intent = new Intent(this.getContext(), UserActivity.class);

            intent.putExtra("userId", userItemPresenter.getUserId());
            intent.putExtra("userLogin", userItemPresenter.getUserLogin());

            usersListFragment.startActivity(intent);
        }

        /*switch (view.getId()) {

            case R.id.ivUserItemPhoto:
                Intent intent = new Intent(this.getContext(), UserActivity.class);

                intent.putExtra("userId", userItemPresenter.getUserId());
                intent.putExtra("userLogin", userItemPresenter.getUserLogin());

                usersListFragment.startActivity(intent);
                break;
            case R.id.btnUserItemSubscribe:

                userItemPresenter.subscribeButtonClicked();
                break;
        }*/
    }
}
