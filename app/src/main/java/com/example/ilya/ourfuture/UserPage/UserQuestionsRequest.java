package com.example.ilya.ourfuture.UserPage;

import com.example.ilya.ourfuture.Shared.PageParams;

/**
 * Created by Ilya on 26.07.2018.
 */

public class UserQuestionsRequest {
    int userId;
    int userPageId;
    PageParams pageParams;
    final int backgroundSizeType = 1;

    public UserQuestionsRequest(int userId, int userPageId, PageParams pageParams) {
        this.userId = userId;
        this.userPageId = userPageId;
        this.pageParams = pageParams;
    }
}
