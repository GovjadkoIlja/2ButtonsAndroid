package com.example.ilya.ourfuture.UserPage;

import java.util.List;

/**
 * Created by Ilya on 14.01.2018.
 */

public interface IPostsModel {
    void receivePosts(int userId);
    int getPageOwnerId();
    int getId();
    List<Post> getPosts();
}
