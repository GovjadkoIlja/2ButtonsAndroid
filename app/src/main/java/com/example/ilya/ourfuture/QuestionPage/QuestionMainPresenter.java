package com.example.ilya.ourfuture.QuestionPage;

import com.example.ilya.ourfuture.Question.QuestionsList;

/**
 * Created by Ilya on 13.02.2018.
 */

public class QuestionMainPresenter implements IQuestionMainPresenter {

    final int defaultMinAge = 0;
    final int defaultMaxAge = 100;
    final int defaultSex = 0;

    IQuestionMainView questionMainView;
    IQuestionMainModel questionMainModel;

    public QuestionMainPresenter(int id, IQuestionMainView _questionMainView) {
        questionMainView = _questionMainView;
        questionMainModel = new QuestionMainModel(id, this);

        if (questionMainModel.isAnswered())
            getAnsweredInfo();

    }

    private void getAnsweredInfo() {
        questionMainModel.getResults(defaultMinAge, defaultMaxAge, defaultSex);
    }

    private void answer(int answer) {
        questionMainModel.saveAnswer(answer);
        questionMainModel.getResults(defaultMinAge, defaultMaxAge, defaultSex);
    }

    @Override
    public void optionClicked(int option) {
        if (questionMainModel.isAnswered())
            questionMainView.getPeopleList(questionMainModel.getId(), QuestionsList.getNextQuestion().questionId, option, QuestionsList.getNextQuestion().options.get(0).text, QuestionsList.getNextQuestion().options.get(1).text);
        else
            answer(option);

    }

    @Override
    public void representAnswered(int firstOption, int secondOption, int yourAnswer) {
        questionMainView.representAnswers(firstOption, secondOption);
        questionMainView.representPercents((int)Math.round((double)firstOption / (double)(firstOption + secondOption) * 100), (int)Math.round((double)secondOption / (double)(firstOption + secondOption) * 100));
        questionMainView.representYourAnswer(yourAnswer);
    }
}
