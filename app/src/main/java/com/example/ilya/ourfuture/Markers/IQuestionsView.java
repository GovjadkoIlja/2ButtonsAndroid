package com.example.ilya.ourfuture.Markers;

import com.example.ilya.ourfuture.Question.Question;

import java.util.ArrayList;

/**
 * Created by Ilya on 07.03.2018.
 */

public interface IQuestionsView {
    void openQuestion(int id);
    void representQuestions(ArrayList<Question> questions);
}
