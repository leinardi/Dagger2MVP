package com.leinardi.dagger2mvp;

import com.leinardi.dagger2mvp.dagger.HostModule;
import com.leinardi.dagger2mvp.dagger.NetworkModule;
import com.leinardi.dagger2mvp.dagger.TestAndroidModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by leinardi on 13/07/16.
 */
@Component(modules = {
        NetworkModule.class,
        HostModule.class,
        TestAndroidModule.class
})
@Singleton
public interface TestAppComponent extends AppComponent {

    void inject(Dagger2MvpApp app);
}
