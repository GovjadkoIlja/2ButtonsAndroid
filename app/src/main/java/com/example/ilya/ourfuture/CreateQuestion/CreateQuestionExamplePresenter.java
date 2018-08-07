package com.example.ilya.ourfuture.CreateQuestion;

import java.util.ArrayList;

/**
 * Created by Ilya on 16.07.2018.
 */

public class CreateQuestionExamplePresenter {
    CreateQuestionExampleFragment createQuestionExampleFragment;
    CreateQuestionExampleModel createQuestionExampleModel;

    public CreateQuestionExamplePresenter(CreateQuestionExampleFragment createQuestionExampleFragment) {
        this.createQuestionExampleFragment = createQuestionExampleFragment;
        createQuestionExampleModel = new CreateQuestionExampleModel(this);
    }

    public void getStandardBackgrounds() {
        createQuestionExampleModel.getStandardBackgrounds();
    }

    public void backgoundsGot(ArrayList<String> backgrounds) {
        System.out.println("BBB");

        createQuestionExampleModel.saveBackgrounds(backgrounds);

        String url = createQuestionExampleModel.getBackground(0);

        createQuestionExampleFragment.setBackground(url);
    }

    public String getBackground(int delta) {
        return createQuestionExampleModel.getBackground(delta);
    }
}
