package com.TwoButtons.ilya.TwoButtons.Markers;

import com.TwoButtons.ilya.TwoButtons.Shared.PageParams;

/**
 * Created by Ilya on 03.06.2018.
 */

public class MarkersRequest {
    int userId;
    int sortType;
    final int backgroundSizeType = 1;
    PageParams pageParams;

    public MarkersRequest(int userId, int sortType, PageParams pageParams) {
        this.userId = userId;
        this.sortType = sortType;
        this.pageParams = pageParams;
    }
}
