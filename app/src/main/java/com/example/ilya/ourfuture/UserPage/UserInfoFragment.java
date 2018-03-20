package com.example.ilya.ourfuture.UserPage;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ilya.ourfuture.R;
import com.example.ilya.ourfuture.Shared.Id;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserInfoFragment extends Fragment implements IUserInfoView {

    IUserInfoPresenter userInfoPresenter;

    TextView tvLogin;
    TextView tvAgeSex;
    TextView tvDescription;
    ImageView ivHeFollowed;
    ImageButton btnFollow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_info, null);

        tvLogin = (TextView) view.findViewById(R.id.tvUserLogin);
        tvAgeSex = (TextView) view.findViewById(R.id.tvUserAgeSex);
        tvDescription = (TextView) view.findViewById(R.id.tvUserDescription);
        ivHeFollowed = (ImageView) view.findViewById(R.id.ivUserHeFollowed);
        btnFollow = (ImageButton) view.findViewById(R.id.btnUserFollow);

        Bundle args = getArguments();

        //int id = args.getInt("id");
        int userId = args.getInt("userId", Id.getId());

        userInfoPresenter = new UserInfoPresenter(Id.getId(), this);
        userInfoPresenter.getUserInfo(Id.getId(), userId);

        //QuestionsList.getQuestions(id, userId);

        return view;
    }

    @Override
    public void setLogin(String login) {
        tvLogin.setText(login);
    }

    @Override
    public void setAgeSex(int age, String sex) {
        String ageSex = age + " лет, " + sex;
        tvAgeSex.setText(ageSex);
    }

    @Override
    public void setDescription(String description) {
        tvDescription.setText(description);
    }

    @Override
    public void setButtons(boolean isMine, boolean heFollowed, boolean youFollowed) {
        if (isMine) {
            btnFollow.setImageResource(R.drawable.settings);
            ivHeFollowed.setVisibility(View.GONE);
        } else {
            if (heFollowed) {
                ivHeFollowed.setVisibility(View.VISIBLE);
                ivHeFollowed.setImageResource(R.drawable.he_followed);
            }
            if (youFollowed)
                btnFollow.setImageResource(R.drawable.you_followed);
            else
                btnFollow.setImageResource(R.drawable.add);
        }
    }
}
