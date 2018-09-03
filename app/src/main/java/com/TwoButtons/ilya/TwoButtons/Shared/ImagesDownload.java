package com.TwoButtons.ilya.TwoButtons.Shared;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Ilya on 04.07.2018.
 */

public class ImagesDownload {
    public static void setCircleImage(String url, ImageView view) {

        if (url != null)
            url = url.replace("2buttons", "4buttons");

        Picasso.with(view.getContext()).load(ServerConnection.getMediaServerAddress(url)).resize(400, 400).centerCrop()
                .transform(new CircularTransformation()).into(view);
    }
}
