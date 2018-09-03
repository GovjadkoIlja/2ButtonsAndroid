package com.TwoButtons.ilya.TwoButtons.Followers;

import com.TwoButtons.ilya.TwoButtons.Shared.PageParams;

/**
 * Created by Ilya on 28.08.2018.
 */

public class RecommendedRequest {
    int userId;
    PageParams pageParams;

    RecommendedRequest(int userId, PageParams pageParams) {
        this.userId = userId;
        this.pageParams = pageParams;
    }
}
