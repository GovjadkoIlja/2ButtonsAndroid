package com.example.ilya.ourfuture.UserPage;

import com.example.ilya.ourfuture.Question.Question;

import java.util.ArrayList;

/**
 * Created by Ilya on 14.01.2018.
 */

public interface IPostsModel {
    void receivePosts(int userId);
    int getPageOwnerId();
    int getId();
    ArrayList<Question> getQuestions();
}
