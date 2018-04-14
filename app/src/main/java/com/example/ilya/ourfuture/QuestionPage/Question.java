package com.example.ilya.ourfuture.QuestionPage;

import com.example.ilya.ourfuture.UserPage.Post;

/**
 * Created by Ilya on 09.02.2018.
 */

public class Question {
    public int questionId;
    public String condition;
    public String firstOption;
    public String secondOption;
    public int questionType;
    public String asked;
    int askerId;
    public String login;
    String avatarLink;
    public int answers;
    public int raiting;
    public int yourFeedback;
    public int inFavorites;
    public int answered;

    public Question(Post post) {
        questionId = post.questionID;
        condition = post.condition;
        firstOption = post.firstOption;
        secondOption = post.secondOption;
        questionType = post.questionType;
        asked = post.questionAddDate;
        askerId = post.avatarUserID;
        login = post.login;
        avatarLink = post.avatarLink;
        answers = post.anwsers;
        raiting = post.raiting;
        yourFeedback = post.yourFeedback;
        inFavorites = post.inFavorites;
        answered = post.anwsered;
    }

    public Question(Question question) {
        questionId = question.questionId;
        condition = question.condition;
        firstOption = question.firstOption;
        secondOption = question.secondOption;
        questionType = question.questionType;
        asked = question.asked;
        askerId = question.askerId;
        login = question.login;
        avatarLink = question.avatarLink;
        answers = question.answers;
        raiting = question.raiting;
        yourFeedback = question.yourFeedback;
        inFavorites = question.inFavorites;
        answered = question.answered;
    }
}


