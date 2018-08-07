package com.example.ilya.ourfuture.Voters;

/**
 * Created by Ilya on 30.06.2018.
 */

public class VotersRequest {
    int userId;
    int questionId;
    int answerType;

    public VotersRequest(int userId, int questionId, int answerType) {
        this.userId = userId;
        this.questionId = questionId;
        this.answerType = answerType;
    }
}
