package com.example.ilya.ourfuture.UserPage;

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
 * Created by Ilya on 14.01.2018.
 */

public class PostsModel implements IPostsModel {

    IPostsPresenter postsPresenter;

    int userId;
    List<Post> posts;

    public PostsModel(int _userId, IPostsPresenter _postsPresenter) {
        postsPresenter = _postsPresenter;
        userId = _userId;
    }

    @Override
    public void receivePosts(int userId) {
        Gson gson = new GsonBuilder().create();

        Retrofit searchRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(ServerConnection.URL)
                .build();

        IPostsRequest postsIntf = searchRetrofit.create(IPostsRequest.class);

        postsIntf.getPosts(Id.getId(), userId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> parseResponse(n));
    }

    @Override
    public int getPageOwnerId() {
        return userId;
    }

    @Override
    public int getId() {
        return Id.getId();
    }

    @Override
    public List<Post> getPosts() {
        return posts;
    }

    private void parseResponse(JsonElement s) {
        System.out.println(Id.getId());

        System.out.println(s);

        Type postsListType = new TypeToken<List<Post>>() {}.getType();

        Gson gson = new Gson();

        posts = gson.fromJson(s, postsListType);

        postsPresenter.postsGot(posts);
    }
}
