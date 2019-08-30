package com.agibaev.boredapp;

import android.app.Application;
import com.agibaev.boredapp.utils.ISharedStorage;
import com.agibaev.boredapp.utils.SharedStorage;

public class App extends Application {

    public static ISharedStorage sharedStorage;
    public static AppPreferences appPreferences;

    @Override
    public void onCreate() {
        super.onCreate();

        sharedStorage = new SharedStorage(this, "prefs");
        appPreferences = new AppPreferences(sharedStorage);
    }
}