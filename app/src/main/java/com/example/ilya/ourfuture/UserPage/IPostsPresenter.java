package com.example.ilya.ourfuture.UserPage;

import java.util.List;

/**
 * Created by Ilya on 14.01.2018.
 */

public interface IPostsPresenter {
    void receivePosts(int userId);
    void postsGot(List<Post> posts);
    int getPageOwnerId();
    void questionClicked(int position, List<Post> posts);
    void sinchronizeWithQuestions();
}
