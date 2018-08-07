package com.example.ilya.ourfuture.Question;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ilya.ourfuture.Shared.ImagesDownload;
import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.example.ilya.ourfuture.Voters.VotersActivity;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by Ilya on 22.06.2018.
 */

public class QuestionView extends LinearLayout implements View.OnClickListener {

    final int secondsInMinute = 60;
    final int secondsInHour = secondsInMinute * 60;
    final int secondsInDay = secondsInHour * 24;
    final int secondsInYear = secondsInDay * 365;

    final float middleSize = (float) 0.05;

    Question question;
    QuestionPresenter questionPresenter;
    Fragment parentFragment;

    View rootView;

    ImageView ivBackground;

    ImageView ivPhoto;
    TextView tvLogin;
    TextView tvCondition;
    TextView tvType;
    TextView tvAnswers;
    TextView tvRaiting;
    TextView tvAskDate;
    ImageButton ibLike;
    ImageButton ibDislike;
    ImageButton ibFavorite;

    TextView tvFirstOption;
    TextView tvSecondOption;

    RelativeLayout rlBackground;

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

    ImageButton ibArrowBack;
    ImageButton ibArrowForward;

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

        ivBackground = rootView.findViewById(R.id.ivQuestionBackground);

        ivPhoto = rootView.findViewById(R.id.ivQuestionPhoto);
        tvLogin = rootView.findViewById(R.id.tvQuestionLogin);
        tvCondition = (TextView)rootView.findViewById(R.id.tvQuestionCondition);
        tvAnswers = (TextView)rootView.findViewById(R.id.tvQuestionShows);
        tvRaiting = (TextView)rootView.findViewById(R.id.tvQuestionRaiting);
        tvAskDate = (TextView)rootView.findViewById(R.id.tvQuestionAskDate);
        tvFirstOption = rootView.findViewById(R.id.tvQuestionFirstOptionText);
        tvSecondOption = rootView.findViewById(R.id.tvQuestionSecondOptionText);
        tvType = rootView.findViewById(R.id.tvQuestionType);

        ibLike = (ImageButton) rootView.findViewById(R.id.ibQuestionLike);
        ibDislike = (ImageButton) rootView.findViewById(R.id.ibQuestionDislike);
        ibFavorite = (ImageButton) rootView.findViewById(R.id.ibQuestionFavorite);

        rlBackground = rootView.findViewById(R.id.rlQuestionBackground);

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

        ibArrowBack = rootView.findViewById(R.id.ibQuestionArrowBackgroundBack);
        ibArrowForward = rootView.findViewById(R.id.ibQuestionArrowBackgroundForward);

        rlFirstOption.setOnClickListener(this);
        rlSecondOption.setOnClickListener(this);
        ibLike.setOnClickListener(this);
        ibDislike.setOnClickListener(this);
        ibFavorite.setOnClickListener(this);

        ibArrowBack.setOnClickListener(this);
        ibArrowForward.setOnClickListener(this);

    }

    public void setData(Question question) {
        this.question = question;

        setBackgroundImage(question.backgroundUrl);

        ImagesDownload.setCircleImage(question.author.smallAvatarLink, ivPhoto);

        tvLogin.setText(question.author.login);

        tvCondition.setText(question.condition);

        tvAnswers.setText(question.options.get(0).voters + question.options.get(1).voters + "");
        tvRaiting.setText(question.likesCount - question.dislikesCount + "");

        //getDateText(question.questionAddDate);
        tvAskDate.setText(getDateText(question.questionAddDate));
        //tvAskDate.setText(question.questionAddDate.substring(0, 10));

        tvFirstOption.setText(question.options.get(0).text);
        tvSecondOption.setText(question.options.get(1).text);

        if (question.questionType == 2)
            tvType.setVisibility(VISIBLE);

        setSelectedOption(question.yourAnswerType);

        setSelectedFeedback(0, question.yourFeedbackType);
        setFavorite(question.isInFavorites);
        setResults(question.yourAnswerType, question.options.get(0).voters, question.options.get(1).voters);

        /*setResults(question.yourAnswerType, question.options.get(0).voters, question.options.get(1).voters, row);
        setSelectedFeedback(0, question.yourFeedbackType, ibLike);
        setFavorite(question.isInFavorites, ibFavorite);*/
    }

    public void setBackgroundImage(String url) {

        url = ServerConnection.getMediaServerAddress(url);

        System.out.println(url);

        Picasso.with(getContext()).load(ServerConnection.getMediaServerAddress(url)).fit().centerCrop()
                .into(ivBackground);

        /*Picasso.with(getContext()).load(ServerConnection.getMediaServerAddress(url))
                .resize(1600, 900).centerCrop().into(new Target(){

            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                rlBackground.setBackground(new BitmapDrawable(getContext().getResources(), bitmap));
            }

            @Override
            public void onBitmapFailed(final Drawable errorDrawable) {
                Log.d("TAG", "FAILED");
            }

            @Override
            public void onPrepareLoad(final Drawable placeHolderDrawable) {
                Log.d("TAG", "Prepare Load");
            }
        });*/
    }

    @Override
    public void onClick(View view) {

        int newBackground = 0;
        int newAnswer = -1;
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
                break;

            case (R.id.ibQuestionArrowBackgroundBack):
                newBackground = -1;
                break;

            case (R.id.ibQuestionArrowBackgroundForward):
                newBackground = 1;
                break;

        }

        if (newBackground != 0) {
            ChangingBackgroundClicked backgroundClicked = (ChangingBackgroundClicked) parentFragment;
            backgroundClicked.changeBackground(newBackground);
            return;
        }

        if ((question.yourAnswerType == 0) && (newAnswer != -1)) {
            questionPresenter.addAnswer(question, newAnswer);

            setSelectedOption(newAnswer);
            setResults(newAnswer, question.options.get(0).voters, question.options.get(1).voters);
        } else if ((question.yourAnswerType != 0) && (newAnswer != -1)) {
            if (question.questionType != 2)
                openVoters(newAnswer);
            else
                Toast.makeText(getContext(), "Это анонимный вопрос", Toast.LENGTH_SHORT).show();

        }

        if (newFeedback != question.yourFeedbackType) {
            setSelectedFeedback(question.yourFeedbackType, newFeedback);

            questionPresenter.addFeedback(question, newFeedback); //Here we are updating likes and dislikes as well

            tvRaiting.setText((question.likesCount - question.dislikesCount) + "");
        }
    }

    public void makeBackgroundArrowsVisible() {
        ibArrowBack.setVisibility(VISIBLE);
        ibArrowForward.setVisibility(VISIBLE);
    }

    private void openVoters(int answer) {
        ArrayList<String> options = getOptionsArray(question.options);

        Intent voters = new Intent(this.getContext(), VotersActivity.class);
        voters.putExtra("questionId", question.questionId);
        voters.putExtra("condition", question.condition);
        voters.putExtra("option", answer);
        voters.putExtra("options", options);
        this.getContext().startActivity(voters);
    }
    
    private ArrayList<String> getOptionsArray(ArrayList<Option> options) {
        ArrayList<String> strings = new ArrayList<>();

        for (Option option: options) {
            strings.add(option.text);
        }

        return strings;
    }

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

    private String getDateText(String askString) {

        Calendar askDate = getAskDate(askString);

        Calendar currentDate = new GregorianCalendar();
        currentDate.setTime(new Date());

        int yearsDiff = currentDate.get(Calendar.YEAR) - askDate.get(Calendar.YEAR);
        int daysDiff = currentDate.get(Calendar.DAY_OF_YEAR) - askDate.get(Calendar.DAY_OF_YEAR); //I'll have problems in the end of year

        int diff = getSecondsDiff(askDate, currentDate);

        String result = "";

        if (daysDiff > 1) {
            if (yearsDiff == 0)
                result = getFullDate(askDate);
            else
                result = getFullYearDate(askDate);
        } else if ((daysDiff == 1) && (diff >= 4 * secondsInHour)) {
            result = getYesterdayDate(askDate);
        } else if ((daysDiff == 0) && (diff >= 4 * secondsInHour)) {
            result = getTodayDate(askDate);
        }else if (diff < 4 * secondsInHour && diff >= secondsInHour) {
            result = getHoursDate(diff / secondsInHour);
        } else if (diff < secondsInHour && diff > secondsInMinute) {
            result = getMinutesDate(diff / secondsInMinute);
        } else if (diff < secondsInMinute) {
            result = getSecondsDate(diff);
        }

        //System.out.println(daysDiff);

        return result;
    }

    private Calendar getAskDate(String askString) {
        String cutString;

        if (!askString.equals("Только что")) {
            cutString = askString.substring(0, 19);
            cutString = cutString.replace("T", " ");
        } else
            cutString = askString;

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        try {
            date = format.parse(cutString);
        } catch (ParseException e) {
            e.printStackTrace();
            date = new Date();
        }

        Calendar askDate = new GregorianCalendar();
        askDate.setTime(date);

        return askDate;
    }

    private String getFullYearDate(Calendar askDate) {
        Locale locale = new Locale("ru", "RU");
        DateFormat df = new SimpleDateFormat("dd MMM yyyy в HH:mm", locale);

        return df.format(askDate.getTime());
    }

    private String getFullDate(Calendar askDate) {
        Locale locale = new Locale("ru", "RU");
        DateFormat df = new SimpleDateFormat("dd MMM в HH:mm", locale);

        return df.format(askDate.getTime());
    }

    private String getYesterdayDate(Calendar askDate) {
        return "Вчера в " + getTime(askDate);
    }

    private String getTodayDate(Calendar askDate) {
        return "Сегодня в " + getTime(askDate);
    }

    private String getHoursDate(int hours) {
        if (hours == 1)
            return "час назад";
        else
            return hours + " часа назад";
    }

    private String getMinutesDate(int minutes) {
        if (minutes == 1)
            return "минуту назад";
        else
            return minutes + " минут назад";
    }

    private String getSecondsDate(int seconds) {
        if (seconds <= 3)
            return "Только что";
        else
            return seconds + " cекунд назад";
    }

    private int getSecondsDiff(Calendar askDate, Calendar currentDate) {
        int diffYears = currentDate.get(Calendar.YEAR) - askDate.get(Calendar.YEAR);
        int diffDays = currentDate.get(Calendar.DAY_OF_YEAR) - askDate.get(Calendar.DAY_OF_YEAR);
        int diffHours = currentDate.get(Calendar.HOUR_OF_DAY) - askDate.get(Calendar.HOUR_OF_DAY);
        int diffMins = currentDate.get(Calendar.MINUTE) - askDate.get(Calendar.MINUTE);
        int diffSeconds = currentDate.get(Calendar.SECOND) - askDate.get(Calendar.SECOND);

        /*System.out.println(diffYears * secondsInYear + " " + diffDays * secondsInDay + " " +
                diffHours * secondsInHour + " " + diffMins * secondsInMinute + " " + diffSeconds);*/
        int diff = diffYears * secondsInYear + diffDays * secondsInDay + diffHours * secondsInHour + diffMins * secondsInMinute + diffSeconds;

        return diff;
    }

    private String getTime(Calendar askDate) {
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
        String time = f.format(askDate.getTime());
        return time;
    }

    public interface ChangingBackgroundClicked {
        void changeBackground(int offset);
    }

    public void setParentFragment(Fragment parentFragment) {
        this.parentFragment = parentFragment;
    }

}