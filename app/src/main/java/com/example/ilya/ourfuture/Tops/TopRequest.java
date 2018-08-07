package com.example.ilya.ourfuture.Tops;

import com.example.ilya.ourfuture.Shared.PageParams;

/**
 * Created by Ilya on 04.06.2018.
 */

public class TopRequest {
    int userId;
    long deltaUnixTime;
    boolean isOnlyNew;
    int sortType;
    PageParams pageParams;
    final int backgroundSizeType = 1;

    public TopRequest(int userId, long deltaUnixTime, boolean isOnlyNew, int sortType, PageParams pageParams) {
        this.userId = userId;
        this.deltaUnixTime = deltaUnixTime;
        this.isOnlyNew = isOnlyNew;
        this.sortType = sortType;
        this.pageParams = pageParams;
    }
}
