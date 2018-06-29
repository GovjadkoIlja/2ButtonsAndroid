package com.example.ilya.ourfuture.Question;

/**
 * Created by Ilya on 02.06.2018.
 */

public class AddAnswerRequest {
    int userId;
    int questionId;
    int answerType;

    public AddAnswerRequest(int userId, int questionId, int answerType) {
        this.userId = userId;
        this.questionId = questionId;
        this.answerType = answerType;
    }
}
