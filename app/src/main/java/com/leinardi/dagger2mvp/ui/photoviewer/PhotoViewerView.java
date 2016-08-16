package com.leinardi.dagger2mvp.ui.photoviewer;

import com.leinardi.dagger2mvp.ui.base.BaseView;

/**
 * Created by leinardi on 13/07/16.
 */

public interface PhotoViewerView extends BaseView {

    void setTitle(String title);

    void setSubtitle(String subtitle);

    void showImage(String url);
}
