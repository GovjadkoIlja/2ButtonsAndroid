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
 * Created by Ilya on 16.02.2018.
 */

public class QuestionPeopleListModel implements IQuestionPeopleListModel {

    /*final String IP_ADDRESS = "http://192.168.1.95";
    final String PORT = "8080";
    final String URL = IP_ADDRESS + ":" + PORT;*/

    IPeopleListPresenter peopleListPresenter;

    List<ShortUser> firstOption;
    List<ShortUser> secondOption;

    QuestionPeopleListModel(IPeopleListPresenter _peopleListPresenter) {
        peopleListPresenter = _peopleListPresenter;
    }


    @Override
    public void receiveAnsweredPeopleList(int id, int questionId, int option, int minAge, int maxAge, int sex, String search) {

        System.out.println(id);

        Gson gson = new GsonBuilder().create();

        Retrofit searchRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(ServerConnection.URL)
                .build();

        IQuestionPeopleListRequest votersIntf = searchRetrofit.create(IQuestionPeopleListRequest.class);

        votersIntf.getVoters(id, questionId, option, minAge, maxAge, sex, search)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> parseResponse(n, questionId, option, minAge, maxAge, sex, search));

    }

    @Override
    public List<ShortUser> getAnsweredList(int option) {
        return option == 1 ? firstOption : secondOption;
    }

    private void parseResponse(JsonElement s, int questionId, int option, int minAge, int maxAge, int sex, String search) {
        Type peopleListType = new TypeToken<List<ShortUser>>() {}.getType();

        Gson gson = new Gson();

        if (option == 1) {
            firstOption = gson.fromJson(s, peopleListType);
            if (secondOption == null) {
                peopleListPresenter.peopleGot(firstOption);
                receiveAnsweredPeopleList(Id.getId(), questionId, 2, minAge, maxAge, sex, search); //Receive immediately if another option list still doesn't exist
            }
        }
        else {
            secondOption = gson.fromJson(s, peopleListType);
            if (firstOption == null) {
                peopleListPresenter.peopleGot(secondOption);
                receiveAnsweredPeopleList(Id.getId(), questionId, 1, minAge, maxAge, sex, search); //Receive immediately if another option list still doesn't exist
            }
        }


    }
}
