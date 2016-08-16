package com.leinardi.dagger2mvp.ui.hitdetail;

import com.leinardi.dagger2mvp.model.Hit;
import com.leinardi.dagger2mvp.ui.base.BaseView;

/**
 * Created by leinardi on 13/07/16.
 */

public interface HitDetailView extends BaseView {

    void showName(String name);

    void showSubLine(String subLine);

    void showStartTime(String startTime);

    void showDescription(String description);

    void showImage(String url);

    void showImageInPhotoViewer(Hit hit);
}
