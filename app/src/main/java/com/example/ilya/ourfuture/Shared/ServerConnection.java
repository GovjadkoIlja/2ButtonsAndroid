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
    private static final String IP_ADDRESS = "https://api.4buttons.ru";
    private static final String MEDIA_SERVER = "https://media.4buttons.ru";

    //private static final String PORT = "6255";
    //public static final String URL = IP_ADDRESS + ":" + PORT;
    public static final String URL = IP_ADDRESS;

    public static final String version = "/v0.13";

    public static Retrofit prepareRetrofit() {
        Gson gson = new GsonBuilder().create();

        Retrofit searchRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(ServerConnection.URL)
                .build();

        return searchRetrofit;
    }

    public static String getMediaServerAddress(String url) {

        if (url == null)
            return null;
        else if (url.startsWith("http"))  {
            if (!url.startsWith("https"))
                url = url.replaceFirst("http", "https");
            return url;
        }
        else
            return MEDIA_SERVER + "/" + url;
    }
}
