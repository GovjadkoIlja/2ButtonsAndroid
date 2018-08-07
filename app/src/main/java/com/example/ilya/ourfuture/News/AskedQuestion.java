package com.example.ilya.ourfuture.News;

/**
 * Created by Ilya on 04.07.2018.
 */

public class AskedQuestion extends NewsQuestion {
    public AskedQuestion(String condition, String firstOption, String secondOption, String backgroundImageLink, int questionType) {
        super(condition, firstOption, secondOption, backgroundImageLink, questionType);
    }

    @Override
    public String getDescription() {
        String description =  author.login + " спросил";

        return description;
    }
}
