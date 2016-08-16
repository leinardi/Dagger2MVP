package com.leinardi.dagger2mvp.ui.hitlist;

import com.leinardi.dagger2mvp.ui.base.BaseInteractor;

/**
 * Created by leinardi on 13/07/16.
 */

public interface HitListInteractor extends BaseInteractor {

    void loadhitList(HitListListener hitListListener);
}
