package com.leinardi.dagger2mvp.ui.photoviewer;

import dagger.Subcomponent;

/**
 * Created by leinardi on 13/07/16.
 */

@PhotoViewerScope
@Subcomponent(modules = {
        PhotoViewerModule.class
})
public interface PhotoViewerComponent {

    void inject(PhotoViewerActivity activity);
}
