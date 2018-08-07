package com.example.ilya.ourfuture.Shared;

import android.view.View;
import android.widget.ImageView;

import com.example.ilya.ourfuture.Shared.CircularTransformation;
import com.example.ilya.ourfuture.Shared.HeaderFragment;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Shared.ServerConnection;
import com.squareup.picasso.Picasso;

/**
 * Created by Ilya on 04.07.2018.
 */

public class ImagesDownload {
    public static void setCircleImage(String url, ImageView view) {
        Picasso.with(view.getContext()).load(ServerConnection.getMediaServerAddress(url)).resize(400, 400).centerCrop()
                .transform(new CircularTransformation()).into(view);
    }
}
