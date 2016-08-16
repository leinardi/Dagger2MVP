package com.leinardi.dagger2mvp.ui.hitdetail;

import com.leinardi.dagger2mvp.model.Hit;
import com.leinardi.dagger2mvp.ui.base.BasePresenter;

/**
 * Created by leinardi on 13/07/16.
 */

public interface HitDetailPresenter extends BasePresenter {

    void loadHitDetail(Hit hit);

    void onImageSelected();
}
