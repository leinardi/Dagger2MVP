package com.leinardi.dagger2mvp.ui.hitlist;

import com.leinardi.dagger2mvp.model.Hit;
import com.leinardi.dagger2mvp.ui.base.BaseView;

import java.util.List;

/**
 * Created by leinardi on 13/07/16.
 */

public interface HitListView extends BaseView {

    void showhits(List<Hit> hitList);

    void showhitDetails(Hit hit);

    void startRefreshing();

    void stopRefreshing();
}
