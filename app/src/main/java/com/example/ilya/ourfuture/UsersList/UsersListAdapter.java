package com.example.ilya.ourfuture.UsersList;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ilya.ourfuture.PeopleList.ShortUser;
import com.example.ilya.ourfuture.Question.Question;
import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.UserPage.UserActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilya on 09.06.2018.
 */

public class UsersListAdapter extends ArrayAdapter<Person> {
    /*final String youFollowedText = "Вы подписаны";
    final String followText = "Подписаться";*/

    UsersListFragment usersListFragment;
    ArrayList<Person> people;
    //boolean showAgeSex; //For results
    Context mContext;

    /*ImageView ivPhoto;
    TextView tvLogin;
    Button btnSubscribe;*/

    public UsersListAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull ArrayList<Person> people,
                            UsersListFragment usersListFragment, boolean showAgeSex) {
        super(context, resource, textViewResourceId, people);

        this.people = people;
        this.usersListFragment = usersListFragment;
        //this.showAgeSex = showAgeSex;
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // return super.getView(position, convertView, parent);

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.fragment_user_item, parent,
                false);

        UserItem userItem = row.findViewById(R.id.uiUserList);

        userItem.setData(people.get(position), usersListFragment);

        return row;
    }


}
