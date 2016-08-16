package com.leinardi.dagger2mvp.ui.hitlist;

import dagger.Subcomponent;

/**
 * Created by leinardi on 13/07/16.
 */

@HitListScope
@Subcomponent(modules = {
        HitListModule.class
})
public interface HitListComponent {

    void inject(HitListActivity activity);
}
