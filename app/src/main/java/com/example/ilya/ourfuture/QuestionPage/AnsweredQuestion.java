package com.example.ilya.ourfuture.QuestionPage;

import com.example.ilya.ourfuture.PeopleList.ShortUser;
import com.example.ilya.ourfuture.QuestionPage.Question;
import com.example.ilya.ourfuture.UserPage.Post;

import java.util.ArrayList;

/**
 * Created by Ilya on 13.02.2018.
 */

public class AnsweredQuestion extends Question {

    int yourAnswer;
    int firstAnswers;
    int secondAnswers;
    ArrayList<ShortUser> firstVoters;
    ArrayList<ShortUser> secondVoters;

    public AnsweredQuestion(Post post) {
        super(post);
    }

    public AnsweredQuestion(Question question, int _yourAnswer, int _firstAnswers, int _secondAnswers, ArrayList<ShortUser> _firstVoters, ArrayList<ShortUser> _secondVoters) {
        super(question);

        yourAnswer = _yourAnswer;
        firstAnswers = _firstAnswers;
        secondAnswers = _secondAnswers;
        firstVoters = _firstVoters;
        secondVoters = _secondVoters;
    }
}
