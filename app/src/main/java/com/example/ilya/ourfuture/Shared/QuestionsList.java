package com.example.ilya.ourfuture.Shared;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilya on 09.02.2018.
 */

public class QuestionsList {

    public static ArrayList<Question> questions = new ArrayList<>();
    static int next;

    public static void getQuestions(List<Question> questions, int startIndex){

        next = 0;

        /*for (int i = startIndex; i < questions.size(); i++) {
            Question current = questions.get(i);
            if ((current.yourAnswer == 0) || (i == startIndex))
                QuestionsList.questions.add(new com.example.ilya.ourfuture.QuestionPage.Question(current));
        }*/
    }


    public static Question getNextQuestion() {
        return questions.get(next);
    }

    public static void printQuestions() {
        for (Question q: questions) {
            System.out.println(q.questionId + " " + q.condition);
        }
    }
}


