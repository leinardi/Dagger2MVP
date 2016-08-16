package com.leinardi.dagger2mvp.ui.hitlist;

import com.leinardi.dagger2mvp.model.Hits;
import com.leinardi.dagger2mvp.ui.base.BaseListener;

/**
 * Created by leinardi on 13/07/16.
 */

public interface HitListListener extends BaseListener {

    void onSuccess(Hits hits);
}
