package com.TwoButtons.ilya.TwoButtons.UserPage;

import com.TwoButtons.ilya.TwoButtons.Shared.PageParams;

/**
 * Created by Ilya on 26.07.2018.
 */

public class UserQuestionsRequest {
    int userId;
    int userPageId;
    PageParams pageParams;

    public UserQuestionsRequest(int userId, int userPageId, PageParams pageParams) {
        this.userId = userId;
        this.userPageId = userPageId;
        this.pageParams = pageParams;
    }
}
