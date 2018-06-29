package com.example.ilya.ourfuture.Markers;

/**
 * Created by Ilya on 03.06.2018.
 */

public class MarkersRequest {
    int userId;
    int sortType;

    public MarkersRequest(int userId, int sortType) {
        this.userId = userId;
        this.sortType = sortType;
    }
}
