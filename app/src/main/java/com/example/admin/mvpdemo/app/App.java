package com.example.admin.mvpdemo.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by admin on 2017/3/27.
 */

public class App extends Application{
    public static Context app;
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
