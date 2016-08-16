package com.leinardi.dagger2mvp.dagger;

import com.leinardi.dagger2mvp.network.retrofit.PixabayServer;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by leinardi on 13/07/16.
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public OkHttpClient provideClient(Integer networkTimeout) {
        return new OkHttpClient.Builder()
                .connectTimeout(networkTimeout, TimeUnit.SECONDS)
                .readTimeout(networkTimeout, TimeUnit.SECONDS)
                .writeTimeout(networkTimeout, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    public PixabayServer provideService(String baseUrl, OkHttpClient client) {
        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.newThread());
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .build().create(PixabayServer.class);
    }
}
