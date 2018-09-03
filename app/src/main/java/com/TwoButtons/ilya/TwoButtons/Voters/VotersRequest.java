package com.TwoButtons.ilya.TwoButtons.Voters;

/**
 * Created by Ilya on 30.06.2018.
 */

public class VotersRequest {
    int userId;
    int questionId;
    int answerType;
    String searchedLogin;

    public VotersRequest(int userId, int questionId, int answerType, String searchedLogin) {
        this.userId = userId;
        this.questionId = questionId;
        this.answerType = answerType;
        this.searchedLogin = searchedLogin;
    }
}
