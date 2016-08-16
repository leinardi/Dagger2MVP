package com.leinardi.dagger2mvp.ui.hitlist;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leinardi on 13/07/16.
 */

@Module
public class HitListModule {
    private HitListView view;

    public HitListModule(HitListView view) {
        this.view = view;
    }

    @HitListScope
    @Provides
    public HitListView provideView() {
        return view;
    }

    @HitListScope
    @Provides
    public HitListInteractor provideInteractor(HitListInteractorImpl interactor) {
        return interactor;
    }

    @HitListScope
    @Provides
    public HitListPresenter providePresenter(HitListPresenterImpl presenter) {
        return presenter;
    }
}
