package com.TwoButtons.ilya.TwoButtons.Shared;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.TwoButtons.ilya.TwoButtons.Followers.FollowersActivity;
import com.TwoButtons.ilya.TwoButtons.UserPage.UserActivity;
import com.android.ilya.TwoButtons.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeaderFragment extends Fragment implements View.OnClickListener {

    ImageButton btnBack;
    TextView tvHeader;
    //TextView tvHelp;
    ImageButton ibMyPage;

    boolean isFollowers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_header, null);

        btnBack = view.findViewById(R.id.btnBack);
        tvHeader = view.findViewById(R.id.tvHeader);
        ibMyPage = view.findViewById(R.id.ibHeaderMyPage);

        Bundle args = getArguments();

        isFollowers = args.getBoolean("isFollowers", false);
        tvHeader.setText(args.getString("headerText", ""));

        if (isFollowers) {
            ibMyPage.setImageResource(R.drawable.recommended);
            //ibMyPage.setLayoutParams(new RelativeLayout.LayoutParams(30, 30));
            /*ibMyPage.setMaxWidth(30);
            ibMyPage.setMaxHeight(30);*/

        } else
            ImagesDownload.setCircleImage(Id.smallAvatarLink, ibMyPage);

        if (args.getBoolean("showBack", true)) {
            btnBack.setOnClickListener(this);
            btnBack.setVisibility(View.VISIBLE);
        } else
            btnBack.setVisibility(View.INVISIBLE);

        if (args.getBoolean("showPhoto", true)) {
            ibMyPage.setOnClickListener(this);
            ibMyPage.setVisibility(View.VISIBLE);
        } else
            ibMyPage.setVisibility(View.INVISIBLE);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.btnBack):
                this.getActivity().onBackPressed();
                break;
            case (R.id.ibHeaderMyPage):
                if (isFollowers) {
                    ((FollowersActivity)getActivity()).getRecommendedFriends();
                    ibMyPage.setImageResource(R.drawable.recommended_enabled);
                } else {
                    Intent intent = new Intent(this.getActivity(), UserActivity.class);
                    intent.putExtra("userId", Id.getId());
                    intent.putExtra("userLogin", Id.getLogin());
                    startActivity(intent);
                    break;
                }
        }
    }

    public interface RecommendedFriendsListener {
        void getRecommendedFriends();
    }
}
