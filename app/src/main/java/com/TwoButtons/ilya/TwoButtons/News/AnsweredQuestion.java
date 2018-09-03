package com.TwoButtons.ilya.TwoButtons.News;

/**
 * Created by Ilya on 01.07.2018.
 */

public class AnsweredQuestion extends NewsQuestion {
    int answeredFollowToAmount;

    public AnsweredQuestion(String condition, String firstOption, String secondOption, String backgroundImageLink, int questionType, int answeredFollowToAmount) {
        super(condition, firstOption, secondOption, backgroundImageLink, questionType);
        this.answeredFollowToAmount = answeredFollowToAmount;
    }

    @Override
    public String getDescription() {
        String description = answeredFollowToAmount + " подписок ответили на вопрос";
        return description;
    }
}
