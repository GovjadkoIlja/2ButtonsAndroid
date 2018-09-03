package com.TwoButtons.ilya.TwoButtons.News;

/**
 * Created by Ilya on 03.07.2018.
 */

public class CommentedQuestion extends NewsQuestion {
    int commentUserId;
    String commentUserLogin;
    int userCommentsAmount;


    public CommentedQuestion(String condition, String firstOption, String secondOption, String backgroundImageLink, int questionType,
                             int commentUserId, String commentUserLogin, int userCommentsAmount) {
        super(condition, firstOption, secondOption, backgroundImageLink, questionType);
        this.commentUserId = commentUserId;
        this.commentUserLogin = commentUserLogin;
        this.userCommentsAmount = userCommentsAmount;
    }

    @Override
    public String getDescription() {
        String description = commentUserLogin + " оставил " + userCommentsAmount + " комментариев";
        return description;
    }
}
