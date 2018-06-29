package com.example.ilya.ourfuture.UserPage;

import com.example.ilya.ourfuture.Question.Question;

import java.util.ArrayList;

/**
 * Created by Ilya on 14.01.2018.
 */

public interface IPostsPresenter {
    void receivePosts(int userId);
    void postsGot(ArrayList<Question> questions);
    int getPageOwnerId();
    void questionClicked(int position, ArrayList<Question> questions);
    //void sinchronizeWithQuestions();
}
