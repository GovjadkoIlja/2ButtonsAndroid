package com.example.ilya.ourfuture.Tops;

/**
 * Created by Ilya on 04.06.2018.
 */

public class TopRequest {
    int userId;
    long deltaUnixTime;
    boolean isOnlyNew;
    int sortType;

    public TopRequest(int userId, long deltaUnixTime, boolean isOnlyNew, int sortType) {
        this.userId = userId;
        this.deltaUnixTime = deltaUnixTime;
        this.isOnlyNew = isOnlyNew;
        this.sortType = sortType;
    }
}
