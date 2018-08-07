package com.example.ilya.ourfuture.Shared;

/**
 * Created by Ilya on 28.07.2018.
 */

public class PageParams {
    public static int defaultQuestionsCount = 10;

    int offset;
    int count;

    public PageParams(int offset, int count) {
        this.offset = offset;
        this.count = count;
    }
}
