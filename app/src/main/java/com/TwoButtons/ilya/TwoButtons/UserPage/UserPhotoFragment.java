package com.TwoButtons.ilya.TwoButtons.UserPage;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.TwoButtons.ilya.TwoButtons.Shared.ImagesDownload;
import com.android.ilya.TwoButtons.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserPhotoFragment extends Fragment {

    ImageView ivPhoto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user_photo, container, false);

        ivPhoto = view.findViewById(R.id.ivUserPhoto);

        return view;
    }


    public void setPhoto(String url) {
        ImagesDownload.setCircleImage(url, ivPhoto);
    }
}
