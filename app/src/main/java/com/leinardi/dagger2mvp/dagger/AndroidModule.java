package com.leinardi.dagger2mvp.dagger;

import android.content.Context;
import android.net.ConnectivityManager;

import com.leinardi.dagger2mvp.Dagger2MvpApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leinardi on 13/07/16.
 */

@Module
public class AndroidModule {
    private final Dagger2MvpApp mApplication;

    public AndroidModule(Dagger2MvpApp application) {
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
        return (ConnectivityManager) mApplication.getSystemService(Context.CONNECTIVITY_SERVICE);
    }
}
