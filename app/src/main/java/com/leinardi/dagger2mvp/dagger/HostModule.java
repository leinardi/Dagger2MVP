package com.leinardi.dagger2mvp.dagger;

import android.text.format.DateUtils;

import com.leinardi.dagger2mvp.BuildConfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leinardi on 13/07/16.
 */

@Module
public class HostModule {
    private static final int NETWORK_TIMEOUT_SECONDS = 10;

    @Provides
    @Singleton
    public String provideBaseUrl() {
        return BuildConfig.API_URL;
    }

    @Provides
    @Singleton
    public Integer provideNetworkTimeout() {
        return NETWORK_TIMEOUT_SECONDS * (int) DateUtils.SECOND_IN_MILLIS;
    }
}
