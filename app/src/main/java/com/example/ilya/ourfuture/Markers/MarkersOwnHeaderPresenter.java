package com.example.ilya.ourfuture.Markers;

/**
 * Created by Ilya on 01.03.2018.
 */

public class MarkersOwnHeaderPresenter implements IMarkersOwnHeaderPresenter {

    IMarkersOwnHeaderFragment markersOwnHeaderFragment;

    public MarkersOwnHeaderPresenter(IMarkersOwnHeaderFragment _markersOwnHeaderFragment) {
        markersOwnHeaderFragment = _markersOwnHeaderFragment;
    }

    @Override
    public void buttonClicked(int number) {
        markersOwnHeaderFragment.setButtons(number);
    }
}
