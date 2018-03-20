package com.example.ilya.ourfuture.UserPage;

import com.example.ilya.ourfuture.QuestionPage.Question;
import com.example.ilya.ourfuture.Shared.QuestionsList;

import java.util.List;

/**
 * Created by Ilya on 14.01.2018.
 */

public class PostsPresenter implements IPostsPresenter {

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
    public void postsGot(List<Post> posts) {
        postsView.representPosts(posts);
    }

    @Override
    public int getPageOwnerId() {
        return postsModel.getPageOwnerId();
    }

    @Override
    public void questionClicked(int position, List<Post> posts) {
        QuestionsList.questions.clear();
        QuestionsList.getQuestions(posts, position);
        postsView.openQuestion(postsModel.getId());
    }

    @Override
    public void sinchronizeWithQuestions() {

        List<Post> posts = postsModel.getPosts();

        if (posts == null)
            return;

        for (Question question: QuestionsList.questions) {
            for (Post post: posts) {
                if (question.questionId == post.questionID) {
                    post.anwsered = question.answered;
                    post.raiting = question.raiting;
                    post.yourFeedback = question.yourFeedback;
                    post.inFavorites = question.inFavorites;
                }
            }
        }

        postsView.representPosts(posts);
    }


}
