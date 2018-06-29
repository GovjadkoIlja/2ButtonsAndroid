package com.example.ilya.ourfuture.Question;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ilya.ourfuture.R;

/**
 * Created by Ilya on 22.06.2018.
 */

public class QuestionView extends LinearLayout implements View.OnClickListener {
    final float middleSize = (float) 0.05;

    Question question;
    QuestionPresenter questionPresenter;

    View rootView;

    TextView tvLogin;
    TextView tvCondition;
    TextView tvType;
    TextView tvAnswers;
    TextView tvRaiting;
    TextView tvAskDate;
    ImageView ivAnswered;
    ImageButton ibLike;
    ImageButton ibDislike;
    ImageButton ibFavorite;

    TextView tvFirstOption;
    TextView tvSecondOption;

    RelativeLayout rlFirstOption;
    RelativeLayout rlSecondOption;

    LinearLayout llResults;
    RelativeLayout rlFirstOptionQuestionLine;
    RelativeLayout rlMiddleLine;
    RelativeLayout rlSecondOptionQuestionLine;

    TextView tvFirstOptionQuestionLinePercent;
    TextView tvSecondOptionQuestionLinePercent;
    TextView tvFirstOptionQuestionLineVoters;
    TextView tvSecondOptionQuestionLineVoters;

    public QuestionView(Context context) {
        super(context);
        init(context);
    }

    public QuestionView(Context context, AttributeSet attr) {
        super(context, attr);
        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.question, this);

        questionPresenter = new QuestionPresenter();

        tvLogin = rootView.findViewById(R.id.tvQuestionLogin);

        tvCondition = (TextView)rootView.findViewById(R.id.tvQuestionCondition);
        tvAnswers = (TextView)rootView.findViewById(R.id.tvQuestionShows);
        tvRaiting = (TextView)rootView.findViewById(R.id.tvQuestionRaiting);
        tvAskDate = (TextView)rootView.findViewById(R.id.tvQuestionAskDate);
        tvFirstOption = rootView.findViewById(R.id.tvQuestionFirstOptionText);
        tvSecondOption = rootView.findViewById(R.id.tvQuestionSecondOptionText);

        ibLike = (ImageButton) rootView.findViewById(R.id.ibQuestionLike);
        ibDislike = (ImageButton) rootView.findViewById(R.id.ibQuestionDislike);
        ibFavorite = (ImageButton) rootView.findViewById(R.id.ibQuestionFavorite);

        rlFirstOption = (RelativeLayout)rootView.findViewById(R.id.rlQuestionFirstOption);
        rlSecondOption = (RelativeLayout)rootView.findViewById(R.id.rlQuestionSecondOption);

        llResults = rootView.findViewById(R.id.llQuestionResults);
        rlFirstOptionQuestionLine = rootView.findViewById(R.id.rlQuestionFirstOptionLine);
        rlMiddleLine = rootView.findViewById(R.id.rlQuestionMiddleLine);
        rlSecondOptionQuestionLine = rootView.findViewById(R.id.rlQuestionSecondOptionLine);
        tvFirstOptionQuestionLinePercent = rootView.findViewById(R.id.tvQuestionFirstOptionLinePrecent);
        tvSecondOptionQuestionLinePercent = rootView.findViewById(R.id.tvQuestionSecondOptionLinePrecent);
        tvFirstOptionQuestionLineVoters = rootView.findViewById(R.id.tvQuestionFirstOptionLineVoters);
        tvSecondOptionQuestionLineVoters = rootView.findViewById(R.id.tvQuestionSecondOptionLineVoters);

        rlFirstOption.setOnClickListener(this);
        rlSecondOption.setOnClickListener(this);
        ibLike.setOnClickListener(this);
        ibDislike.setOnClickListener(this);
        ibFavorite.setOnClickListener(this);
    }

    public void setData(Question question) {
        this.question = question;

        tvLogin.setText(question.login);

        tvCondition.setText(question.condition);

        tvAnswers.setText(question.showsAmount + "");
        tvRaiting.setText(question.likesAmount - question.dislikesAmount + "");
        tvAskDate.setText(question.questionAddDate.substring(0, 10));

        tvFirstOption.setText(question.options.get(0).text);
        tvSecondOption.setText(question.options.get(1).text);

        setSelectedOption(question.yourAnswerType);

        setSelectedFeedback(0, question.yourFeedbackType);
        setFavorite(question.isInFavorites);
        setResults(question.yourAnswerType, question.options.get(0).voters, question.options.get(1).voters);

        /*setResults(question.yourAnswerType, question.options.get(0).voters, question.options.get(1).voters, row);
        setSelectedFeedback(0, question.yourFeedbackType, ibLike);
        setFavorite(question.isInFavorites, ibFavorite);*/
    }

    @Override
    public void onClick(View view) {
        //Question question = getClickedQuestion(view);

        int newAnswer = question.yourAnswerType;
        int newFeedback = question.yourFeedbackType;

        switch (view.getId()) {
            case (R.id.rlQuestionFirstOption):
                newAnswer = 1;
                break;

            case (R.id.rlQuestionSecondOption):
                newAnswer = 2;
                break;

            case (R.id.ibQuestionLike):
                newFeedback = getNewFeedback(question.yourFeedbackType, 1);
                break;

            case (R.id.ibQuestionDislike):
                newFeedback = getNewFeedback(question.yourFeedbackType, -1);
                break;

            case (R.id.ibQuestionFavorite):
                setFavorite(!question.isInFavorites);
                questionPresenter.addFavorites(question, !question.isInFavorites);
                //question.isInFavorites = !question.isInFavorites;
                //questionsListPresenter.addFavorites(question, !question.isInFavorites);
                break;

        }

        System.out.println(question.questionId);

        if ((question.yourAnswerType == 0) && (newAnswer != question.yourAnswerType)) {
            questionPresenter.addAnswer(question, newAnswer);

            setSelectedOption(newAnswer);
            setResults(newAnswer, question.options.get(0).voters, question.options.get(1).voters);
        }

        if (newFeedback != question.yourFeedbackType) {
            setSelectedFeedback(question.yourFeedbackType, newFeedback);

            questionPresenter.addFeedback(question, newFeedback); //Here we are updating likes and dislikes as well

            //TextView tvRaiting = ((View) view.getParent()).findViewById(R.id.tvClosedQuestionRaiting);

            tvRaiting.setText((question.likesAmount - question.dislikesAmount) + "");
        }
    }

    /*private Question getClickedQuestion(View view) {
        View parentRow;

        switch (view.getId()) { //dependency from the layout
            case R.id.ibClosedQuestionFavorite:
                parentRow =  (View) view.getParent().getParent().getParent().getParent();
                break;
            default:
                parentRow = (View) view.getParent().getParent().getParent();

        }

        ListView listView = (ListView) parentRow.getParent();
        int position = listView.getPositionForView(parentRow);

        return questions.get(position);
    }*/

    private void setSelectedOption(int position) {
        if (position == 1)
            rlFirstOption.setBackgroundColor(this.getResources().getColor(R.color.colorSelectedOption));
        else if (position == 2)
            rlSecondOption.setBackgroundColor(this.getResources().getColor(R.color.colorSelectedOption));
    }

    private void setSelectedFeedback(int oldFeedback, int feedback) {
        if (feedback == oldFeedback)
            return;

        /*View parent = (View) view.getParent();

        ImageButton ibLike = parent.findViewById(R.id.ibClosedQuestionLike);
        ImageButton ibDislike = parent.findViewById(R.id.ibClosedQuestionDislike);*/

        if (oldFeedback == 1) {
            ibLike.setImageResource(R.drawable.thumb_up);
        }
        else if (oldFeedback == -1) {
            ibDislike.setImageResource(R.drawable.thumb_down);
        }

        if (feedback == 1)
            ibLike.setImageResource(R.drawable.thumb_up_selected);
        else if (feedback == -1)
            ibDislike.setImageResource(R.drawable.thumb_down_selected);
    }

    private void setFavorite(boolean isInFavorites) {
        if (!isInFavorites)
            ibFavorite.setImageResource(R.drawable.favorite);
        else
            ibFavorite.setImageResource(R.drawable.favorite_selected);
    }

    private int getNewFeedback(int oldFeedback, int feedbackClicked) {
        if (oldFeedback == feedbackClicked)
            return 0;

        return feedbackClicked;
    }

    private void setResults(int yourAnswer, int firstOption, int secondOption) {
        if (yourAnswer != 1 && yourAnswer != 2)
            return;

        //LinearLayout llResults = view.findViewById(R.id.llClosedQuestionResults);

        llResults.setVisibility(View.VISIBLE);

        setResultsSizes(firstOption, secondOption, middleSize);
        setResultsColors(yourAnswer);
        setResultsText(firstOption, secondOption);
    }

    private void setResultsSizes(float firstOption, float secondOption, float middleSize) {
        float sum = firstOption + secondOption;

        /*RelativeLayout rlFirstOptionQuestionLine = view.findViewById(R.id.rlClosedQuestionFirstOptionLine);
        RelativeLayout rlMiddleLine = view.findViewById(R.id.rlClosedQuestionMiddleLine);
        RelativeLayout rlSecondOptionQuestionLine = view.findViewById(R.id.rlClosedQuestionSecondOptionLine);*/

        rlFirstOptionQuestionLine.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,
                0.5f - (firstOption/sum - middleSize*firstOption/sum)/2f));
        rlSecondOptionQuestionLine.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,
                0.5f - (secondOption/sum - middleSize*secondOption/sum)/2f));

        rlMiddleLine.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,
                0.5f - middleSize/2f));
    }

    private void setResultsColors(int yourAnswer) {

        /*RelativeLayout rlFirstOptionQuestionLine = view.findViewById(R.id.rlClosedQuestionFirstOptionLine);
        RelativeLayout rlMiddleLine = view.findViewById(R.id.rlClosedQuestionMiddleLine);
        RelativeLayout rlSecondOptionQuestionLine = view.findViewById(R.id.rlClosedQuestionSecondOptionLine);*/

        rlMiddleLine.setBackgroundColor(Color.TRANSPARENT);

        if (yourAnswer == 1) {
            rlFirstOptionQuestionLine.setBackgroundColor(getResources().getColor(R.color.colorQuestionResultsSelected));
            rlSecondOptionQuestionLine.setBackgroundColor(getResources().getColor(R.color.colorQuestionResultsNotSelected));
        }
        else {
            rlFirstOptionQuestionLine.setBackgroundColor(getResources().getColor(R.color.colorQuestionResultsNotSelected));
            rlSecondOptionQuestionLine.setBackgroundColor(getResources().getColor(R.color.colorQuestionResultsSelected));
        }
    }

    private void setResultsText(int firstOption, int secondOption) {
        int sum = firstOption + secondOption;

        int firstPrecent = Math.round((float)firstOption / (float)sum * 100);
        int secondPrecent = Math.round((float)secondOption / (float)sum * 100);

        /*tvFirstOptionQuestionLinePercent = view.findViewById(R.id.tvClosedQuestionFirstOptionLinePrecent);
        tvSecondOptionQuestionLinePercent = view.findViewById(R.id.tvClosedQuestionSecondOptionLinePrecent);
        tvFirstOptionQuestionLineVoters = view.findViewById(R.id.tvClosedQuestionFirstOptionLineVoters);
        tvSecondOptionQuestionLineVoters = view.findViewById(R.id.tvClosedQuestionSecondOptionLineVoters);*/

        tvFirstOptionQuestionLinePercent.setText(firstPrecent + "%");
        tvSecondOptionQuestionLinePercent.setText(secondPrecent + "%");

        tvFirstOptionQuestionLineVoters.setText(firstOption + "");
        tvSecondOptionQuestionLineVoters.setText(secondOption + "");
    }

}
