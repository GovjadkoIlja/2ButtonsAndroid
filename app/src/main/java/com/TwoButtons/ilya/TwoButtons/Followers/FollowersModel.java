package com.TwoButtons.ilya.TwoButtons.Followers;

import com.TwoButtons.ilya.TwoButtons.Shared.PageParams;
import com.TwoButtons.ilya.TwoButtons.Shared.ServerConnection;
import com.TwoButtons.ilya.TwoButtons.Shared.ErrorHandler;
import com.TwoButtons.ilya.TwoButtons.Shared.Id;
import com.TwoButtons.ilya.TwoButtons.UsersList.UsersListModel;
import com.TwoButtons.ilya.TwoButtons.UsersList.UsersListPresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Ilya on 10.06.2018.
 */

public class FollowersModel extends UsersListModel {
    UsersListPresenter followersPresenter;
    int userId;

    final int recommendedUsersAmount = 200;

    public FollowersModel(FollowersPresenter followersPresenter, int userId) {
        this.usersListPresenter = followersPresenter;
        this.userId = userId;
    }

    public void receiveFollowers(String searchLogin) {

        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IFollowersRequest postsIntf = searchRetrofit.create(IFollowersRequest.class);

        postsIntf.getFollowers(new FollowersRequest(Id.getId(), userId, searchLogin))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> usersListPresenter.usersListGot(n.data), e -> followersPresenter.errorOccured(ErrorHandler.getErrorType(e)));
    }

    public void receiveFollowTo(String searchLogin) {

        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IFollowersRequest postsIntf = searchRetrofit.create(IFollowersRequest.class);

        postsIntf.getFollowTo(new FollowersRequest(Id.getId(), userId, searchLogin))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> usersListPresenter.usersListGot(n.data), e -> followersPresenter.errorOccured(ErrorHandler.getErrorType(e)));
    }

    public void receiveRecommended() {

        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IRecommendedRequest recommendedIntf = searchRetrofit.create(IRecommendedRequest.class);

        recommendedIntf.getRecommended(new RecommendedRequest(Id.getId(), new PageParams(0, recommendedUsersAmount)))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> ((FollowersPresenter)usersListPresenter).recommendedUsersGot(n.data), e -> followersPresenter.errorOccured(ErrorHandler.getErrorType(e)));
    }

}
