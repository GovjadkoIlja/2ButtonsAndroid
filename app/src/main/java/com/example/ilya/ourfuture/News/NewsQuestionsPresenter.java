package com.example.ilya.ourfuture.News;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ilya on 04.07.2018.
 */

public class NewsQuestionsPresenter {
    NewsQuestionsFragment newsQuestionsFragment;
    NewsQuestionsModel newsQuestionsModel;

    public NewsQuestionsPresenter(NewsQuestionsFragment newsQuestionsFragment) {
        this.newsQuestionsFragment = newsQuestionsFragment;

        newsQuestionsModel = new NewsQuestionsModel(this);
    }

    public void receiveQuestions() {
        newsQuestionsModel.receiveQuestions();
    }

    public void questionsGot(NewsArrays newsArrays) {
        //System.out.println(newsArrays.newsAnsweredQuestions.get(0).condition);

        /*ArrayList<NewsQuestion> finalArray = new ArrayList<>();

        for (NewsQuestion newsQuestion: newsArrays.newsAnsweredQuestions) {
            finalArray.add(newsQuestion);
        }*/

        newsQuestionsModel.incrementOffset();

        ArrayList<NewsQuestion> newArray = getNewsArray(newsArrays);

        ArrayList<NewsQuestion> finalArray = newsQuestionsModel.getNewsQuestions();

        if ((finalArray == null) || (finalArray.size() == 0))
            newsQuestionsFragment.representQuestions(newArray);
        else {
            finalArray.addAll(newArray);

            newsQuestionsModel.setNewsQuestion(finalArray);
        }
    }

    public ArrayList<NewsQuestion> getNewsArray(NewsArrays newsArrays) {
        int newsAmount = getNewsAmount(newsArrays);

        System.out.println("AAAAAAAAAAAAA " + newsAmount);

        if ((newsAmount == 0) && (newsQuestionsModel.getNewsQuestions().size() == 0))
            errorOccured(3);
        
        NewsQuestion[] newsQuestions = new NewsQuestion[newsAmount];

        for (AskedQuestion question: newsArrays.newsAskedQuestions)
            newsQuestions[question.position] = question;
        for (AnsweredQuestion question: newsArrays.newsAnsweredQuestions)
            newsQuestions[question.position] = question;
        for (RecommendedQuestion question: newsArrays.newsRecommendedQuestions)
            newsQuestions[question.position] = question;
        for (FavoriteQuestion question: newsArrays.newsFavoriteQuestions)
            newsQuestions[question.position] = question;
        for (CommentedQuestion question: newsArrays.newsCommentedQuestions)
            newsQuestions[question.position] = question;

        ArrayList<NewsQuestion> newsQuestionArrayList = new ArrayList<>(Arrays.asList(newsQuestions));

        System.out.println(newsQuestionArrayList.size() + " AABB");
        return newsQuestionArrayList;
    }

    private int getNewsAmount(NewsArrays newsArrays) {
        int sum = 0;

        sum += newsArrays.newsAskedQuestions.size();
        sum += newsArrays.newsAnsweredQuestions.size();
        sum += newsArrays.newsFavoriteQuestions.size();
        sum += newsArrays.newsCommentedQuestions.size();
        sum += newsArrays.newsRecommendedQuestions.size();
        
        return sum;
    }

    private void fillArray(NewsQuestion[] newsQuestions, ArrayList<NewsQuestion> newsQuestionArrayList) {
        for (NewsQuestion question: newsQuestionArrayList) {
            newsQuestions[question.position] = question;
        }
    }

    public void errorOccured(int errorType) {
        System.out.println(errorType + " AAAAAA");

        newsQuestionsFragment.errorOccured(errorType);
    }
}
