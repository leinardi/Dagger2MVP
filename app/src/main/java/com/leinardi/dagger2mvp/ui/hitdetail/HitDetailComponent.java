package com.leinardi.dagger2mvp.ui.hitdetail;

import dagger.Subcomponent;

/**
 * Created by leinardi on 13/07/16.
 */

@HitDetailScope
@Subcomponent(modules = {
        HitDetailModule.class
})
public interface HitDetailComponent {

    void inject(HitDetailActivity activity);
}
