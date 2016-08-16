package com.leinardi.dagger2mvp;

import com.leinardi.dagger2mvp.dagger.TestAndroidModule;

/**
 * Created by leinardi on 14/07/16.
 */

public class TestDagger2MvpApp extends Dagger2MvpApp {

    private TestAppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerTestAppComponent.builder()
                .testAndroidModule(new TestAndroidModule(this))
                .build();
    }

    @Override
    public AppComponent getApplicationComponent() {
        return component;
    }
}
