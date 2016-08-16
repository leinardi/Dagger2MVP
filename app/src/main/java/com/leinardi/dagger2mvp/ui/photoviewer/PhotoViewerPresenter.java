package com.leinardi.dagger2mvp.ui.photoviewer;

import com.leinardi.dagger2mvp.model.Hit;
import com.leinardi.dagger2mvp.ui.base.BasePresenter;

/**
 * Created by leinardi on 13/07/16.
 */

public interface PhotoViewerPresenter extends BasePresenter {

    void loadhitImage(Hit hit);

}
