package com.leinardi.dagger2mvp.ui.hitdetail;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leinardi on 13/07/16.
 */

@Module
public class HitDetailModule {

    private HitDetailView view;

    public HitDetailModule(HitDetailView view) {
        this.view = view;
    }

    @HitDetailScope
    @Provides
    public HitDetailView provideView() {
        return view;
    }


    @HitDetailScope
    @Provides
    public HitDetailPresenter providePresenter(HitDetailPresenterImpl presenter) {
        return presenter;
    }
}
