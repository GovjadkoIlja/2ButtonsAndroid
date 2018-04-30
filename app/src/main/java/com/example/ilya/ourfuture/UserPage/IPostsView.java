package com.example.ilya.ourfuture.UserPage;

import com.example.ilya.ourfuture.Shared.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilya on 14.01.2018.
 */

public interface IPostsView {
    void representPosts(ArrayList<Question> questions);
    void openQuestion(int id, int position, ArrayList<Question> questions);
}
