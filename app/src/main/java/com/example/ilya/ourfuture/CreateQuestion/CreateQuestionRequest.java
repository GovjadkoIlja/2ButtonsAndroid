package com.example.ilya.ourfuture.CreateQuestion;

/**
 * Created by Ilya on 24.06.2018.
 */

public class CreateQuestionRequest {
    int userId;
    String condition;
    boolean isAnonimous;
    int audienceType;
    int questionType;
    String firstOption;
    String secondOption;
    String backgroundUrl;

    public CreateQuestionRequest(int userId, String condition, boolean isAnonimous, int audienceType,
                                 int questionType, String firstOption, String secondOption, String backgroundUrl) {
        this.userId = userId;
        this.condition = condition;
        this.isAnonimous = isAnonimous;
        this.audienceType = audienceType;
        this.questionType = questionType;
        this.firstOption = firstOption;
        this.secondOption = secondOption;
        this.backgroundUrl = backgroundUrl;
    }
}


