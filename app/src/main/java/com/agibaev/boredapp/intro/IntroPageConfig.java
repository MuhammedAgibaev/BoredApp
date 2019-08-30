package com.agibaev.boredapp.intro;

import androidx.annotation.StringRes;

public class IntroPageConfig {

    @StringRes
    public int titleRes;

    public int getTitleRes() {
        return titleRes;
    }

    public void setTitleRes(int titleRes) {
        this.titleRes = titleRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public int getImageRes() {
        return imageRes;
    }

    @StringRes
    public int imageRes;

    public IntroPageConfig(int titleRes, int imageRes) {
        this.titleRes = titleRes;
        this.imageRes = imageRes;
    }
}


