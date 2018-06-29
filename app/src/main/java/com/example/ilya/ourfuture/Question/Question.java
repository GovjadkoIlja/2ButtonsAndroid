package com.example.ilya.ourfuture.Question;

import com.example.ilya.ourfuture.Shared.Id;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ilya on 14.01.2018.
 */

public class Question implements Serializable {
    public int questionId;
    public String condition;
    public ArrayList<Option> options;
    public String backgroundImageLink;
    public int questionType;
    public String questionAddDate;

    public int userID;
    public String login;
    public String smallAvatarLink;

    public int showsAmount;
    public int likesAmount;
    public int dislikesAmount;
    public int yourFeedbackType;
    public int yourAnswerType;
    public boolean isInFavorites;
    public boolean isSaved;
    public int commentsAmount;

    //Constructor to create a question
    public Question(String condition, String firstOption, String secondOption, String backgroundImageLink, int questionType) {
        this.questionId = 0;
        this.condition = condition;

        options = new ArrayList<>();
        options.add(new Option(firstOption, 0));
        options.add(new Option(secondOption, 0));
        this.backgroundImageLink = backgroundImageLink;
        this.questionType = questionType;
        this.questionAddDate = "Только что";

        this.userID = Id.getId();
        this.login = Id.getLogin();
        //this.smallAvatarLink =

        this.showsAmount = 0;
        this.likesAmount = 0;
        this.dislikesAmount = 0;
        this.yourFeedbackType = 0;
        this.yourAnswerType = 0;
        this.isInFavorites = false;
        this.isSaved = false;
        this.commentsAmount = 0;
    }
}
