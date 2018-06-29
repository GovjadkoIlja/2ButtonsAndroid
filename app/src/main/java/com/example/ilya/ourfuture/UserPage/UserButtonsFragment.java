package com.example.ilya.ourfuture.UserPage;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ilya.ourfuture.Followers.FollowersActivity;
import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.Id;

public class UserButtonsFragment extends Fragment implements IUserButtonsView, View.OnClickListener {

    IUserButtonsPresenter userButtonsPresenter;
    boolean isYoursPage;

    Button btnFollow;
    UserButton ubFollowers;
    UserButton ubFollowTo;
    UserButton ubStatistics;

    final String followersDescription = "Подписчики";
    final String followToDescription = "Подписки";
    final String statisticsDescription = "Статистика";
    final String follow = "Подписаться";
    final String followed = "Вы подписаны";
    final String edit = "Редактировать";


    //LinearLayout llFollowers;
    //LinearLayout llFollowTo;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user_buttons, container, false);

        Bundle args = getArguments();

        //int id = args.getInt("id");
        int userId = args.getInt("userId", Id.getId());

        userButtonsPresenter = new UserButtonsPresenter(userId, this);

        btnFollow = view.findViewById(R.id.btnUserButtonsFollow);
        ubFollowers = view.findViewById(R.id.ubFollowers);
        ubFollowTo = view.findViewById(R.id.ubFollowTo);
        ubStatistics = view.findViewById(R.id.ubStatistics);

        setButtonsDescriptions();

        btnFollow.setOnClickListener(this);
        ubFollowers.setOnClickListener(this);
        ubFollowTo.setOnClickListener(this);

        /*llFollowers = view.findViewById(R.id.llUserFollowers);
        llFollowTo = view.findViewById(R.id.llUserFollowTo);
        llFollowers.setOnClickListener(this);
        llFollowTo.setOnClickListener(this);*/

        return view;
    }

    private void setButtonsDescriptions() {
        ubFollowers.setDescription(followersDescription);
        ubFollowTo.setDescription(followToDescription);
        ubStatistics.setDescription(statisticsDescription);
    }

    public void setButtonsValues(UserInfo user) {
        userButtonsPresenter.saveUserInfo(user);

        ubFollowers.setValue(user.followersAmount);
        ubFollowTo.setValue(user.followedAmount);

        isYoursPage = userButtonsPresenter.getUserId() == Id.getId();

        setButtonFollow(isYoursPage, user.isYouFollowed);

    }

    @Override
    public void setButtonFollow(boolean isYoursPage, boolean isFollowed) {
        btnFollow.setVisibility(View.VISIBLE);

        if (isYoursPage) {
            btnFollow.setText(edit);
            btnFollow.setTextColor(getResources().getColor(R.color.colorBlack));
            btnFollow.setBackground(getResources().getDrawable(R.drawable.button_you_subscribed));
            return;
        }

        if (isFollowed) {
            btnFollow.setText(followed);
            btnFollow.setTextColor(getResources().getColor(R.color.colorBlack));
            btnFollow.setBackground(getResources().getDrawable(R.drawable.button_you_subscribed));
        }
        else {
            btnFollow.setText(follow);
            btnFollow.setTextColor(getResources().getColor(R.color.colorWhite));
            btnFollow.setBackground(getResources().getDrawable(R.drawable.button_subscribe));
        }
    }

    @Override
    public void getPeopleList(int userId, int listType) {
        Intent intent = new Intent(this.getActivity(), FollowersActivity.class);
        //intent.putExtra("id", id);
        intent.putExtra("userId", userId);
        intent.putExtra("listType", listType);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {

        int clickedLayout = 0;

        switch (view.getId()) {
            case (R.id.ubFollowers):
                clickedLayout = 1;
                break;
            case (R.id.ubFollowTo):
                clickedLayout = 2;
                break;
            case R.id.btnUserButtonsFollow:
                if (!isYoursPage)
                    userButtonsPresenter.updateFollow();
                break;
        }

        if (clickedLayout > 0)
            userButtonsPresenter.layoutClicked(clickedLayout);
    }




}
