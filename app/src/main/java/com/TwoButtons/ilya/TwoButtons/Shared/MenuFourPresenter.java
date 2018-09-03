package com.TwoButtons.ilya.TwoButtons.Shared;

/**
 * Created by Ilya on 04.06.2018.
 */

public class MenuFourPresenter implements IMenuFourPresenter {

    public IMenuFourFragment menuFourFragment;

    public MenuFourPresenter (IMenuFourFragment menuFourFragment) {
        this.menuFourFragment = menuFourFragment;
    }

    @Override
    public void buttonClicked(int number, int previousSelected) {

    }
}
