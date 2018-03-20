package com.example.ilya.ourfuture.PeopleList;

import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.UserPage.UserActivity;

import java.util.List;

public class PeopleListFragment extends ListFragment implements IPeopleListView {

    IPeopleListPresenter peopleListPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();

        int userId = args.getInt("userId", Id.getId());
        boolean isFollowers = args.getBoolean("isFollowers", false);
        boolean isFollowTo = args.getBoolean("isFollowTo", false);

        if (isFollowers || isFollowTo) {
            peopleListPresenter = new PeopleListPresenter(userId, this);
            peopleListPresenter.receivePeopleList(isFollowers, isFollowTo);
        }
        else { //Then it's voters
            int questionId = args.getInt("questionId", 0);
            int option = args.getInt("option", 1);

            peopleListPresenter = new PeopleListPresenter(this);
            peopleListPresenter.getVoters(questionId, option);
        }

    }

    @Override
    public void representPeopleList(List<ShortUser> people) {
        PeopleListAdapter peopleListAdapter = new PeopleListAdapter(getActivity(), R.layout.fragment_shortuser, R.layout.fragment_shortuser, people);
        setListAdapter(peopleListAdapter);
    }

    @Override
    public void openUserPage(int id, int userId) {
        Intent intent = new Intent(this.getActivity(), UserActivity.class);

        intent.putExtra("id", id);
        intent.putExtra("userId", userId);
        intent.putExtra("fromRegistration", false);
        startActivity(intent);
    }

    public void questionOptionChanged(int option) {
        peopleListPresenter.questionOptionChanged(option);
    }

    public class PeopleListAdapter extends ArrayAdapter<ShortUser> implements View.OnClickListener {

        List<ShortUser> people;
        Context mContext;

        ImageView ivPhoto;
        TextView tvLogin;
        TextView tvAgeSex;
        ImageView ivHeFollowed;
        ImageButton btnAdd;

        public PeopleListAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<ShortUser> _people) {
            super(context, resource, textViewResourceId, _people);

            people = _people;
            mContext = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // return super.getView(position, convertView, parent);

            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.fragment_shortuser, parent,
                    false);

            ivPhoto = row.findViewById(R.id.ivPeopleListPhoto);
            tvLogin = row.findViewById(R.id.tvPeopleListLogin);
            tvAgeSex = row.findViewById(R.id.tvPeopleListAgeSex);
            ivHeFollowed = row.findViewById(R.id.ivPeopleListHeFollowed);
            btnAdd = row.findViewById(R.id.btnPeopleListAdd);

            ivPhoto.setOnClickListener(this);
            tvLogin.setOnClickListener(this);

            representUser(people.get(position));

            return row;
        }

        private void representUser(ShortUser user) {
            tvLogin.setText(user.login);
            tvAgeSex.setText(peopleListPresenter.getAgeSexText(user.age, user.sex));
            setButtons(user.youFollowed == 1, user.heFollowed == 1);
        }

        private void setButtons(boolean youFollowed, boolean heFollowed) {
            if (!youFollowed)
                btnAdd.setImageResource(R.drawable.add);
            else
                btnAdd.setImageResource(R.drawable.you_followed);

            if (heFollowed) {
                ivHeFollowed.setVisibility(View.VISIBLE);
                ivHeFollowed.setImageResource(R.drawable.he_followed);
            } else
                ivHeFollowed.setVisibility(View.GONE);

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case (R.id.ivPeopleListPhoto):
                case (R.id.tvPeopleListLogin):
                    View parentRow;
                    if (view.getId() == R.id.ivPeopleListPhoto)
                        parentRow = (View) view.getParent().getParent(); //dependency from the layout
                    else
                        parentRow = (View) view.getParent().getParent().getParent(); //dependency from the layout
                    ListView listView = (ListView) parentRow.getParent();
                    int position = listView.getPositionForView(parentRow);

                    peopleListPresenter.userSelected(people.get(position).userID);

                break;
            }
        }
    }
}
