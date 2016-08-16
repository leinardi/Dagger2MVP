package com.leinardi.dagger2mvp.ui.photoviewer;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leinardi on 13/07/16.
 */

@Module
public class PhotoViewerModule {

    private PhotoViewerView view;

    public PhotoViewerModule(PhotoViewerView view) {
        this.view = view;
    }

    @PhotoViewerScope
    @Provides
    public PhotoViewerView provideView() {
        return view;
    }


    @PhotoViewerScope
    @Provides
    public PhotoViewerPresenter providePresenter(PhotoViewerPresenterImpl presenter) {
        return presenter;
    }
}
