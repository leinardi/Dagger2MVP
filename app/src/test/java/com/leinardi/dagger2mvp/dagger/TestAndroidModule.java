package com.leinardi.dagger2mvp.dagger;

import android.content.Context;
import android.net.ConnectivityManager;

import com.leinardi.dagger2mvp.TestDagger2MvpApp;

import org.robolectric.RuntimeEnvironment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leinardi on 13/07/16.
 */

@Module
public class TestAndroidModule {
    private final TestDagger2MvpApp mApplication;

    public TestAndroidModule(TestDagger2MvpApp application) {
        mApplication = application;
    }

    /**
     * Allow the application context to be injected but require that it be annotated with
     * {@link ForApplication @Annotation} to explicitly differentiate it from an activity context.
     */
    @Provides
    @Singleton
    @ForApplication
    Context provideApplicationContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    ConnectivityManager provideConnectivityManager() {
        return (ConnectivityManager) RuntimeEnvironment.application.getSystemService(Context.CONNECTIVITY_SERVICE);
    }
}
