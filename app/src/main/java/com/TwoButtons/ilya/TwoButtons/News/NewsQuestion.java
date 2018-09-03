package com.TwoButtons.ilya.TwoButtons.News;

import com.TwoButtons.ilya.TwoButtons.Question.Question;

/**
 * Created by Ilya on 03.07.2018.
 */

abstract class NewsQuestion extends Question {

    int position;

    public NewsQuestion(String condition, String firstOption, String secondOption, String backgroundImageLink, int questionType) {
        super(condition, firstOption, secondOption, backgroundImageLink, questionType);
    }

    public abstract String getDescription();
}
