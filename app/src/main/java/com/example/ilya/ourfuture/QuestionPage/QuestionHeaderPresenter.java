package com.example.ilya.ourfuture.QuestionPage;

import com.example.ilya.ourfuture.Shared.Question;

import java.util.ArrayList;

/**
 * Created by Ilya on 10.02.2018.
 */

public class QuestionHeaderPresenter implements IQuestionHeaderPresenter {

    IQuestionHeaderModel questionHeaderModel;
    IQuestionHeaderView questionHeaderView;

    QuestionHeaderPresenter(int position, ArrayList<Question> questions, IQuestionHeaderView _questionHeaderView) {
        questionHeaderView = _questionHeaderView;
        questionHeaderModel = new QuestionHeaderModel(position, questions, this);
    }

    @Override
    public void getQuestion() {
        Question question = questionHeaderModel.getNextQuestion();
        representQuestion(question);
    }

    @Override
    public void feedbackChanged(boolean likeButtonPressed) { //Doesn't work correctly
        Question question = questionHeaderModel.getNextQuestion();

        int newFeedback;

        if (likeButtonPressed)
            newFeedback = question.yourFeedback == 1 ? 0 : 1;
        else
            newFeedback = question.yourFeedback == -1 ? 0 : -1;

        /*question.raiting += newFeedback - question.yourFeedback;
        setRaiting(question.raiting);*/

        question.yourFeedback = newFeedback;

        questionHeaderModel.feedbackChanged(newFeedback);
        questionHeaderView.setFeedback(newFeedback == 1, newFeedback == -1);
    }

    @Override
    public void favoritesChanged() {
        Question question = questionHeaderModel.getNextQuestion();
        //question.inFavorites = 1 - question.inFavorites;

        questionHeaderModel.favoritesChanged();
        questionHeaderView.setFavorites(question.inFavorites == 1);
    }

    private void representQuestion(Question question) {
        questionHeaderView.fillLogin(question.login);

        String type;
        /*if (question.questionType == 1)
            type = "Открытый";
        else
            type = "Анонимный";*/

        type = question.questionType == 1 ? "Открытый" : "Анонимный";

        questionHeaderView.fillQuestionType(type);

        setRaiting(question.questionLikesAmount - question.questionDislikesAmount);

        questionHeaderView.setFeedback(question.yourFeedback == 1, question.yourFeedback == -1);
        questionHeaderView.setFavorites(question.inFavorites == 1);
    }

    private void setRaiting(int raiting) {

        questionHeaderView.setRaiting(raiting > 0 ? "+" + raiting : "" + raiting);

        /*if (raiting > 0)
            questionHeaderView.setRaiting("+" + raiting);
        else
            questionHeaderView.setRaiting("" + raiting);*/
    }
}
