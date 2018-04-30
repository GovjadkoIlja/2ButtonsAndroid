package com.example.ilya.ourfuture.UserPage;

import com.example.ilya.ourfuture.Shared.Question;
import com.example.ilya.ourfuture.Shared.QuestionsList;
import com.example.ilya.ourfuture.Shared.QuestionsListPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilya on 14.01.2018.
 */

public class PostsPresenter extends QuestionsListPresenter implements IPostsPresenter  {

    IPostsModel postsModel;
    IPostsView postsView;

    PostsPresenter(int userId, IPostsView _postsView) {
        postsView = _postsView;
        postsModel = new PostsModel(userId, this);
    }

    @Override
    public void receivePosts(int userId) {
        postsModel.receivePosts(userId);
    }

    @Override
    public void postsGot(ArrayList<Question> questions) {
        postsView.representPosts(questions);
    }

    @Override
    public int getPageOwnerId() {
        return postsModel.getPageOwnerId();
    }

    @Override
    public void questionClicked(int position, ArrayList<Question> questions) {
        QuestionsList.questions.clear();
        QuestionsList.getQuestions(questions, position);
        postsView.openQuestion(postsModel.getId(), position, questions);
    }

    /*@Override
    public void sinchronizeWithQuestions() {

        List<Question> questions = postsModel.getQuestions();

        if (questions == null)
            return;

        for (com.example.ilya.ourfuture.QuestionPage.Question question: QuestionsList.questions) {
            for (Question post: questions) {
                if (question.questionId == post.questionID) {
                    post.yourAnswer = question.answered;
                    post.questionLikesAmount = question.raiting;
                    post.yourFeedback = question.yourFeedback;
                    post.inFavorites = question.inFavorites;
                }
            }
        }

        postsView.representPosts(questions);
    }*/


}
