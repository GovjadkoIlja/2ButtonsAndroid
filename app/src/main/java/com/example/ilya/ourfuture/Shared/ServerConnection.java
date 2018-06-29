package com.example.ilya.ourfuture.Shared;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ilya on 27.02.2018.
 */

public final class ServerConnection {
    //private static final String IP_ADDRESS = "http://192.168.1.95";
    //private static final String IP_ADDRESS = "http://192.168.0.105";
    //private static final String IP_ADDRESS = "http://185.173.93.8";
    //private static final String IP_ADDRESS = "http://172.22.0.91";
    //private static final String IP_ADDRESS = "http://192.168.10.163";
    //private static final String IP_ADDRESS = "http://172.22.0.127";
    private static final String IP_ADDRESS = "https://api.2buttons.ru";

    //private static final String PORT = "6255";
    //public static final String URL = IP_ADDRESS + ":" + PORT;
    public static final String URL = IP_ADDRESS;

    public static final String version = "/v0.09";

    public static Retrofit prepareRetrofit() {
        Gson gson = new GsonBuilder().create();

        Retrofit searchRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(ServerConnection.URL)
                .build();

        return searchRetrofit;
    }

}
