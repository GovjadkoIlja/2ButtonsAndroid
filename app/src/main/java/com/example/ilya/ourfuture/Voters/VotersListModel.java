package com.example.ilya.ourfuture.Voters;

import com.example.ilya.ourfuture.Shared.ErrorHandler;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.example.ilya.ourfuture.UsersList.UsersListModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Ilya on 30.06.2018.
 */

public class VotersListModel extends UsersListModel {

    public VotersListModel(VotersListPresenter votersListPresenter){
        usersListPresenter = votersListPresenter;
    }

    public void getVoters(int questionId, int position) {
        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IVotersRequest votersIntf = searchRetrofit.create(IVotersRequest.class);

        votersIntf.getVoters(new VotersRequest(Id.getId(), questionId, position))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> usersListPresenter.usersListGot(n.data),
                        e -> usersListPresenter.errorOccured(ErrorHandler.getErrorType(e)));
    }
}
