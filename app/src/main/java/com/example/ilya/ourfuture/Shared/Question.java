package com.example.ilya.ourfuture.Shared;

import java.io.Serializable;

/**
 * Created by Ilya on 14.01.2018.
 */

public class Question implements Serializable {
    public int questionId;
    public String condition;
    public String firstOption;
    public String secondOption;
    public String backgroundImageLink;
    public int questionType;
    public String questionAddDate;

    public int userID;
    public String login;
    public String smallAvatarLink;

    public int showsAmount;
    public int questionLikesAmount;
    public int questionDislikesAmount;
    public int yourFeedback;
    public int yourAnswer;
    public int inFavorites;
    public int commentsAmount;

    public int firstAnswerAmount;
    public int secondAnswerAmount;
}
