package com.example.ilya.ourfuture.News;

import com.example.ilya.ourfuture.Shared.PageParams;

/**
 * Created by Ilya on 04.07.2018.
 */

public class NewsRequest {
    int userId;
    PageParams pageParams;
    final int backgroundSizeType = 1;


    public NewsRequest(int userId, PageParams pageParams) {
        this.userId = userId;
        this.pageParams = pageParams;
    }
}
