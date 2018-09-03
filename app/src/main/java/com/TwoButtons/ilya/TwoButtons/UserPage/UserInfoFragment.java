package com.TwoButtons.ilya.TwoButtons.UserPage;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.ilya.TwoButtons.R;
import com.TwoButtons.ilya.TwoButtons.Shared.Id;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserInfoFragment extends Fragment implements IUserInfoView {

    IUserInfoPresenter userInfoPresenter;

    //TextView tvLogin;
    TextView tvAgeSex;
    TextView tvDescription;
    //ImageView ivHeFollowed;
    //ImageButton btnFollow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_info, null);

        //tvLogin = (TextView) view.findViewById(R.id.tvUserLogin);
        tvAgeSex = (TextView) view.findViewById(R.id.tvUserAgeSex);
        //tvDescription = (TextView) view.findViewById(R.id.tvUserDescription);
        //ivHeFollowed = (ImageView) view.findViewById(R.id.ivUserHeFollowed);
        //btnFollow = (ImageButton) view.findViewById(R.id.btnUserFollow);

        Bundle args = getArguments();

        //int id = args.getInt("id");
        int userId = args.getInt("userId", Id.getId());

        userInfoPresenter = new UserInfoPresenter(Id.getId(), this);
        userInfoPresenter.getUserInfo(Id.getId(), userId);

        //QuestionsList.getQuestions(id, userId);

        return view;
    }

    @Override
    public void userInfoGot(UserInfo user) {
        UserInfoGot userInfo = (UserInfoGot) this.getActivity();
        userInfo.userInfoGot(user);
    }

    @Override
    public void setAgeSex(int age, String sex) {
        String ageDescription;

        int lastNumber = age % 10;

        if (age >= 10 && age <= 19)
            ageDescription = "лет";
        else if (lastNumber == 1)
            ageDescription = "год";
        else if (lastNumber >= 2 && lastNumber <= 4)
            ageDescription = "года";
        else
            ageDescription = "лет";

        String ageSex = age + " " + ageDescription + " " + sex;
        tvAgeSex.setText(ageSex);
    }

    @Override
    public void setDescription(String description) {
        tvDescription.setText(description);
    }

    @Override
    public void showToast(String toastString) {
        Toast.makeText(this.getActivity(), toastString, Toast.LENGTH_LONG).show();
    }

    public interface UserInfoGot {
        /*String getCondition();
        ArrayList<String> getOptions();*/
        void userInfoGot(UserInfo user);
    }
}
