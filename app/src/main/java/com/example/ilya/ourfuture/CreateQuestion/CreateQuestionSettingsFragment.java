package com.example.ilya.ourfuture.CreateQuestion;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ilya.ourfuture.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateQuestionSettingsFragment extends Fragment {

    SettingsItem siPublicationAnonimity;
    SettingsItem siQuestionAnonimity;
    SettingsItem siOnlyFollowers;

    final String publicationAnonimityText = "Анонимность публикации";
    final boolean isPublicationAnonimityEnabled = false;

    final String questionAnonimityText = "Анонимность вопроса";
    final boolean isQuestionAnonimityEnabled = false;

    final String onlyFollowersText = "Только подписчики";
    final boolean isOnlyFollowersEnabled = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_create_question_settings, container, false);

        siPublicationAnonimity = view.findViewById(R.id.createQuestionSettingsItemPublicationAnonimity);
        siQuestionAnonimity = view.findViewById(R.id.createQuestionSettingsItemQuestionAnonimity);
        siOnlyFollowers = view.findViewById(R.id.createQuestionSettingsItemOnlyFollowers);

        siPublicationAnonimity.setData(publicationAnonimityText, isPublicationAnonimityEnabled);
        siQuestionAnonimity.setData(questionAnonimityText, isQuestionAnonimityEnabled);
        siOnlyFollowers.setData(onlyFollowersText, isOnlyFollowersEnabled);

        return view;
    }

    public boolean getPublicationAnonimity(){
        return siPublicationAnonimity.isEnabled();
    }

    public boolean getQuestionAnonimity(){
        return siQuestionAnonimity.isEnabled();
    }

    public boolean getOnlyFollowers(){
        return siOnlyFollowers.isEnabled();
    }

}
