package com.leinardi.dagger2mvp.network.retrofit;

import com.leinardi.dagger2mvp.BuildConfig;
import com.leinardi.dagger2mvp.model.Hits;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by leinardi on 12/07/16.
 */

public interface PixabayServer {
    @GET("/api/?key=" + BuildConfig.API_KEY + "&q=flowers&image_type=photo")
    Observable<Hits> getData();
}
