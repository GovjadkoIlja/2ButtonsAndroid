package com.example.ilya.ourfuture.Question;

/**
 * Created by Ilya on 02.06.2018.
 */

public class AddFeedbackRequest {
    int userId;
    int questionId;
    int feedbackType;

    public AddFeedbackRequest(int userId, int questionId, int feedbackType) {
        this.userId = userId;
        this.questionId = questionId;
        this.feedbackType = feedbackType;
    }
}
