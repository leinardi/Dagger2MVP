package com.leinardi.dagger2mvp;

import com.leinardi.dagger2mvp.dagger.AndroidModule;
import com.leinardi.dagger2mvp.dagger.HostModule;
import com.leinardi.dagger2mvp.dagger.NetworkModule;
import com.leinardi.dagger2mvp.ui.hitdetail.HitDetailComponent;
import com.leinardi.dagger2mvp.ui.hitlist.HitListComponent;
import com.leinardi.dagger2mvp.ui.hitlist.HitListModule;
import com.leinardi.dagger2mvp.ui.photoviewer.PhotoViewerComponent;
import com.leinardi.dagger2mvp.ui.photoviewer.PhotoViewerModule;
import com.leinardi.dagger2mvp.ui.hitdetail.HitDetailModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by leinardi on 13/07/16.
 */
@Component(modules = {
        NetworkModule.class,
        HostModule.class,
        AndroidModule.class
})
@Singleton
public interface AppComponent {

    void inject(Dagger2MvpApp app);

    HitListComponent plus(HitListModule hitListModule);

    HitDetailComponent plus(HitDetailModule hitDetailModule);

    PhotoViewerComponent plus(PhotoViewerModule photoViewerModule);
}
