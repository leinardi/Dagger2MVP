package com.leinardi.dagger2mvp.ui.hitlist;

import android.net.ConnectivityManager;

import com.leinardi.dagger2mvp.model.Hit;
import com.leinardi.dagger2mvp.model.Hits;
import com.leinardi.dagger2mvp.util.Utils;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by leinardi on 13/07/16.
 */

public class HitListPresenterImpl implements HitListPresenter, HitListListener {

    private final HitListView view;

    private final HitListInteractor interactor;

    @Inject
    ConnectivityManager connectivityManager;

    @Inject
    public HitListPresenterImpl(HitListView hitListView, HitListInteractor hitListInteractor) {
        this.view = hitListView;
        this.interactor = hitListInteractor;
    }

    @Override
    public void loadhitList() {
        if (Utils.isNetworkActive(connectivityManager)) {
            view.startRefreshing();
            interactor.loadhitList(this);
        } else {
            showError("No internet connection available");
        }
    }

    @Override
    public void onhitSelected(Hit hit) {
        view.showhitDetails(hit);
    }

    @Override
    public void cancel() {
        view.stopRefreshing();
        interactor.cancel();
    }

    @Override
    public void onSuccess(Hits hits) {
        view.stopRefreshing();
        view.showhits(hits.getHits());
    }

    @Override
    public void onFailure(String message) {
        showError(message);
    }

    private void showError(String message) {
        view.stopRefreshing();
        view.showhits(new ArrayList<Hit>());
        view.showError(message);
    }
}
