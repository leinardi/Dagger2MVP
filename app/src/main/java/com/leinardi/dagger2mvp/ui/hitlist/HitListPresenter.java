package com.leinardi.dagger2mvp.ui.hitlist;

import com.leinardi.dagger2mvp.model.Hit;
import com.leinardi.dagger2mvp.ui.base.BasePresenter;

/**
 * Created by leinardi on 13/07/16.
 */

public interface HitListPresenter extends BasePresenter {

    void loadhitList();

    void onhitSelected(Hit hit);

}
