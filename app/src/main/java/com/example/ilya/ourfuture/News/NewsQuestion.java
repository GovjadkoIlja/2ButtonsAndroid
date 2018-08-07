package com.example.ilya.ourfuture.News;

import com.example.ilya.ourfuture.Question.Question;

import java.util.ArrayList;

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
