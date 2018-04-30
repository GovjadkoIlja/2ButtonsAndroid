package com.example.ilya.ourfuture.QuestionPage;

import com.example.ilya.ourfuture.Shared.Question;
import com.example.ilya.ourfuture.Shared.QuestionsList;
import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ilya on 13.02.2018.
 */

public class QuestionMainModel implements IQuestionMainModel {

    /*final String IP_ADDRESS = "http://192.168.1.95";
    final String PORT = "8080";
    final String URL = IP_ADDRESS + ":" + PORT;*/

    IQuestionMainPresenter questionMainPresenter;
    int id;
    int answer = -1;

    public QuestionMainModel(int _id, IQuestionMainPresenter _questionMainPresenter) {
        questionMainPresenter = _questionMainPresenter;
        id = _id;
    }

    @Override
    public void saveAnswer(int answer) {
        Question question = QuestionsList.getNextQuestion();

        this.answer = answer;

        Gson gson = new GsonBuilder().create();

        Retrofit searchRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(ServerConnection.URL)
                .build();

        ISaveAnswer saveAnswerIntf = searchRetrofit.create(ISaveAnswer.class);

        saveAnswerIntf.saveAnswer(id, question.questionId, answer)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> System.out.println(n));
    }

    @Override
    public boolean isAnswered() {
        boolean answered = QuestionsList.getNextQuestion().yourAnswer != 0;
        return answered;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void getResults(int minAge, int maxAge, int sex) {

        Gson gson = new GsonBuilder().create();

        Retrofit searchRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(ServerConnection.URL)
                .build();

        IGetResults getResultsIntf = searchRetrofit.create(IGetResults.class);

        getResultsIntf.getResults(id, QuestionsList.getNextQuestion().questionId, minAge, maxAge, sex)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(n -> parseResultsResponse(n));
    }

    private void parseResultsResponse(JsonElement response) {

        JsonObject object = response.getAsJsonObject();

        int firstOption = object.get("firstOption").getAsInt();
        int secondOption = object.get("secondOption").getAsInt();
        int yourAnswer = object.get("yourAnswer").getAsInt();

        if ((answer != -1) && (yourAnswer != answer)) { //If we have answered now
            if ((yourAnswer == 1) && (answer == 2)) {
                firstOption--;
                secondOption++;
            } else if ((yourAnswer == 2) && (answer == 1)) {
                secondOption--;
                firstOption++;
            }

            else if (yourAnswer == 0) {
                if (answer == 1)
                    firstOption++;
                else if (answer == 2)
                    secondOption++;
            }

            yourAnswer = answer;
        }

        questionMainPresenter.representAnswered(firstOption, secondOption, yourAnswer);
    }


}
