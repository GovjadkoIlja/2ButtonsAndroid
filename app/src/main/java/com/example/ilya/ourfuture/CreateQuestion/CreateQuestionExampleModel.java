package com.example.ilya.ourfuture.CreateQuestion;

import com.example.ilya.ourfuture.Followers.FollowersRequest;
import com.example.ilya.ourfuture.Followers.IFollowersRequest;
import com.example.ilya.ourfuture.Markers.MarkersRequest;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.ServerConnection;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Ilya on 16.07.2018.
 */

public class CreateQuestionExampleModel {
    CreateQuestionExamplePresenter createQuestionExamplePresenter;

    ArrayList<String> backgrounds;
    int currentElement = 0;

    public CreateQuestionExampleModel(CreateQuestionExamplePresenter createQuestionExamplePresenter) {
        this.createQuestionExamplePresenter = createQuestionExamplePresenter;
    }

    public void getStandardBackgrounds() {
        Retrofit searchRetrofit = ServerConnection.prepareRetrofit();

        IBackgroundsRequest backgroundsIntf = searchRetrofit.create(IBackgroundsRequest.class);

        System.out.println("AAA");

        backgroundsIntf.getStandardBackgrounds(new BackgroundsRequest())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> createQuestionExamplePresenter.backgoundsGot(n.data.urls));
    }

    public void saveBackgrounds(ArrayList<String> backgrounds) {
        this.backgrounds = backgrounds;
    }

    public String getBackground(int deltaCurrent) {
        //System.out.println(currentElement + " " + backgrounds.get(currentElement) + " " + deltaCurrent);

        if (currentElement == 0 && deltaCurrent == -1)
            currentElement = backgrounds.size() - 1;
        else if (currentElement == backgrounds.size() - 1 && deltaCurrent == 1)
            currentElement = 0;
        else
            currentElement += deltaCurrent;

        System.out.println(currentElement + " " + backgrounds.get(currentElement) + " " + deltaCurrent);

        return backgrounds.get(currentElement);
    }
}
