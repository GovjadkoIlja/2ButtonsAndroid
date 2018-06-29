package com.example.ilya.ourfuture.CreateQuestion;

/**
 * Created by Ilya on 24.06.2018.
 */

public class CreateQuestionRequest {
    int userId;
    String condition;
    boolean isAnonimity;
    int audienceType;
    int questionType;
    String firstOption;
    String secondOption;

    public CreateQuestionRequest(int userId, String condition, boolean isAnonimity, int audienceType,
                                 int questionType, String firstOption, String secondOption)  {
        this.userId = userId;
        this.condition = condition;
        this.isAnonimity = isAnonimity;
        this.audienceType = audienceType;
        this.questionType = questionType;
        this.firstOption = firstOption;
        this.secondOption = secondOption;
    }
}


