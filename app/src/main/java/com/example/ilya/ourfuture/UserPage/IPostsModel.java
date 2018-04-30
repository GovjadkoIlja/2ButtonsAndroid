package com.example.ilya.ourfuture.UserPage;

import com.example.ilya.ourfuture.Shared.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilya on 14.01.2018.
 */

public interface IPostsModel {
    void receivePosts(int userId);
    int getPageOwnerId();
    int getId();
    ArrayList<Question> getQuestions();
}
