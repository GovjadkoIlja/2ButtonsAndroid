package com.example.ilya.ourfuture.Markers;

import com.example.ilya.ourfuture.QuestionPage.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilya on 07.03.2018.
 */

public interface IQuestionsView {
    void openQuestion(int id);
    void representQuestions(ArrayList<Question> questions);
}
