package com.TwoButtons.ilya.TwoButtons.Question;

/**
 * Created by Ilya on 22.06.2018.
 */

public class QuestionPresenter {
    //public QuestionView questionView;
    public QuestionModel questionModel;
    private QuestionView questionView;

    //public abstract void questionClicked(int position, ArrayList<Question> questions);
    //public abstract void receiveQuestions(int userId);

    /*public void questionsGot(ArrayList<Question> questions) {
        questionsListFragment.representQuestions(questions);
    }*/

    public QuestionPresenter(QuestionView questionView) {
        questionModel = new QuestionModel(this);
        this.questionView = questionView;
    }

    public void addAnswer(Question question, int answer) {
        questionModel.addAnswer(question, answer);
        questionView.setAnswersAmount();
    }

    public void addFeedback(Question question, int feedback) {
        questionModel.addFeedback(question, feedback);
    }

    public void addFavorites(Question question, boolean isInFavorites) {
        questionModel.addFavorites(question, isInFavorites);
    }
}
