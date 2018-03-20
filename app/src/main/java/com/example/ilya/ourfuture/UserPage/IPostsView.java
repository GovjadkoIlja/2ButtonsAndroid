package com.example.ilya.ourfuture.UserPage;

import java.util.List;

/**
 * Created by Ilya on 14.01.2018.
 */

public interface IPostsView {
    void representPosts(List<Post> posts);
    void openQuestion(int id);
}
