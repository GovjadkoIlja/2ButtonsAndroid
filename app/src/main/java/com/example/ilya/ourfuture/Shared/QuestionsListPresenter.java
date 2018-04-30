package com.example.ilya.ourfuture.Shared;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilya on 27.04.2018.
 */

public abstract class QuestionsListPresenter {
    public abstract void questionClicked(int position, ArrayList<Question> questions);
}
