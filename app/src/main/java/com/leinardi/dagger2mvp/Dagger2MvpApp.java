package com.leinardi.dagger2mvp;

import android.app.Application;

import com.leinardi.dagger2mvp.dagger.AndroidModule;

/**
 * Created by leinardi on 12/07/16.
 */

public class Dagger2MvpApp extends Application {

    private static Dagger2MvpApp instance;

    private AppComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        applicationComponent = DaggerAppComponent.builder()
                .androidModule(new AndroidModule(this))
                .build();
    }

    public static Dagger2MvpApp getInstance() {
        return instance;
    }

    public AppComponent getApplicationComponent() {
        return applicationComponent;
    }
}
