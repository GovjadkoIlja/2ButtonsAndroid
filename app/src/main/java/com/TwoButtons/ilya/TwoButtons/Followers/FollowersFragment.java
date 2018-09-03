package com.TwoButtons.ilya.TwoButtons.Followers;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.TwoButtons.ilya.TwoButtons.Shared.HeaderFragment;
import com.TwoButtons.ilya.TwoButtons.UsersList.UsersListFragment;
import com.TwoButtons.ilya.TwoButtons.Shared.Id;

/**
 * A simple {@link Fragment} subclass.
 */
public class FollowersFragment extends UsersListFragment implements HeaderFragment.RecommendedFriendsListener {

    int listType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();

        int userId = args.getInt("userId", Id.getId());
        listType = args.getInt("listType", 1);

        usersListPresenter = new FollowersPresenter(this, userId);

        ((FollowersPresenter)usersListPresenter).receiveUsersList(listType, "");
    }


    @Override
    public void searchTextChanged(String search) {
        ((FollowersPresenter)usersListPresenter).receiveUsersList(listType, search);
    }


    @Override
    public void getRecommendedFriends() {
        //System.out.println("REC");
        ((FollowersPresenter)usersListPresenter).receiveUsersList(3, "");
    }
}
