package com.TwoButtons.ilya.TwoButtons.Voters;

import com.TwoButtons.ilya.TwoButtons.Shared.ServerConnection;
import com.TwoButtons.ilya.TwoButtons.Shared.ErrorHandler;
import com.TwoButtons.ilya.TwoButtons.Shared.Id;
import com.TwoButtons.ilya.TwoButtons.UsersList.UsersListModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Ilya on 30.06.2018.
 */

public class VotersListModel extends UsersListModel {

    String searchText;

    public VotersListModel(VotersListPresenter votersListPresenter){
        usersListPresenter = votersListPresenter;
    }

    public void getVoters(int questionId, int position, String searchText) {
        this.searchText = searchText;

        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IVotersRequest votersIntf = searchRetrofit.create(IVotersRequest.class);

        votersIntf.getVoters(new VotersRequest(Id.getId(), questionId, position, searchText))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> usersListPresenter.usersListGot(n.data),
                        e -> usersListPresenter.errorOccured(ErrorHandler.getErrorType(e)));
    }

    public String getSearchText() {
        return searchText;
    }
}
