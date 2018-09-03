package com.TwoButtons.ilya.TwoButtons.News;

import com.TwoButtons.ilya.TwoButtons.Shared.PageParams;

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
