package com.example.ilya.ourfuture.UsersList;

import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.ServerConnection;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Ilya on 27.06.2018.
 */

public class UserItemModel {
    Person person;

    public UserItemModel(Person person) {
        this.person = person;
    }

    public void subscribe() {
        person.isYouFollowed = true;

        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IFollowRequest followRequestIntf = searchRetrofit.create(IFollowRequest.class);

        followRequestIntf.follow(new FollowRequest(Id.getId(), person.userId))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(System.out::println);
    }

    public void unsubscribe() {
        person.isYouFollowed = false;

        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IFollowRequest followRequestIntf = searchRetrofit.create(IFollowRequest.class);

        followRequestIntf.unfollow(new FollowRequest(Id.getId(), person.userId))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(System.out::println);
    }

    public void savePerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}
