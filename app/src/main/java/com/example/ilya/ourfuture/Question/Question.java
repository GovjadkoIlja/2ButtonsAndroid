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
    public String backgroundUrl;
    public int questionType;
    public String questionAddDate;

    public Author author;

    /*public int userID;
    public String login;
    public String smallAvatarLink;*/

    //public int showsCount;
    public int likesCount;
    public int dislikesCount;
    public int yourFeedbackType;
    public int yourAnswerType;
    public boolean isInFavorites;
    public boolean isSaved;
    public int commentsCount;

    //Constructor to create a question
    public Question(String condition, String firstOption, String secondOption, String backgroundUrl, int questionType) {
        this.questionId = 0;
        this.condition = condition;

        options = new ArrayList<>();
        options.add(new Option(firstOption, 0));
        options.add(new Option(secondOption, 0));
        this.backgroundUrl = backgroundUrl;
        this.questionType = questionType;
        //this.questionAddDate = new Date();
        this.questionAddDate = "Только что";

        this.author = new Author();

        this.author.userID = Id.getId();
        this.author.login = Id.getLogin();
        this.author.smallAvatarLink = Id.getSmallAvatarLink();

        //this.showsCount = 0;
        this.likesCount = 0;
        this.dislikesCount = 0;
        this.yourFeedbackType = 0;
        this.yourAnswerType = 0;
        this.isInFavorites = false;
        this.isSaved = false;
        this.commentsCount = 0;
    }
}