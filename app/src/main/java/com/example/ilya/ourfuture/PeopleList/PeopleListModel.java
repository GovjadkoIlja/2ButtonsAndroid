package com.example.ilya.ourfuture.PeopleList;

import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Ilya on 16.01.2018.
 */

public class PeopleListModel implements IPeopleListModel {

    /*final String IP_ADDRESS = "http://192.168.1.95";
    final String PORT = "8080";
    final String URL = IP_ADDRESS + ":" + PORT;*/

    IPeopleListPresenter peopleListPresenter;

    List<ShortUser> people;
    int userId;

    PeopleListModel(int _userId, IPeopleListPresenter _peopleListPresenter) {
        peopleListPresenter = _peopleListPresenter;
        userId = _userId;
    }

    @Override
    public void receivePeopleList(boolean isFollowers, boolean isFollowTo) {
        Gson gson = new GsonBuilder().create();

        Retrofit searchRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(ServerConnection.URL)
                .build();

        IPeopleListRequest postsIntf = searchRetrofit.create(IPeopleListRequest.class);

        if (isFollowers) {
            postsIntf.getFollowers(Id.getId(), userId)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(n -> parseResponse(n));
        } else if (isFollowTo) {
            postsIntf.getFollowTo(Id.getId(), userId)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(n -> parseResponse(n));
        }
    }

    private void parseResponse(JsonElement s) {
        Type peopleListType = new TypeToken<List<ShortUser>>() {}.getType();

        Gson gson = new Gson();

        people = gson.fromJson(s, peopleListType);

        peopleListPresenter.peopleGot(people);
    }
}
