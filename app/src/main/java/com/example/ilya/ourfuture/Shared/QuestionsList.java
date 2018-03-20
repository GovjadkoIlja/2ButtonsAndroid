package com.example.ilya.ourfuture.Shared;

import com.example.ilya.ourfuture.QuestionPage.Question;
import com.example.ilya.ourfuture.UserPage.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilya on 09.02.2018.
 */

public class QuestionsList {

    public static ArrayList<Question> questions = new ArrayList<>();
    static int next;

    public static void getQuestions(List<Post> posts, int startIndex){

        next = 0;

        for (int i = startIndex; i < posts.size(); i++) {
            Post current = posts.get(i);
            if ((current.anwsered == 0) || (i == startIndex))
                questions.add(new Question(current));
        }
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


