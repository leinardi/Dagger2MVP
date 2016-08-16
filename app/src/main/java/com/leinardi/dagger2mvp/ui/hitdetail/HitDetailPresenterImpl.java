package com.leinardi.dagger2mvp.ui.hitdetail;

import android.util.Log;

import com.leinardi.dagger2mvp.model.Hit;

import javax.inject.Inject;

/**
 * Created by leinardi on 13/07/16.
 */

public class HitDetailPresenterImpl implements HitDetailPresenter {

    private static final String TAG = HitDetailPresenterImpl.class.getSimpleName();
    private final HitDetailView view;
    private Hit hit;

    @Inject
    public HitDetailPresenterImpl(HitDetailView hitDetailView) {
        this.view = hitDetailView;
    }


    @Override
    public void loadHitDetail(Hit hit) {
        this.hit = hit;
        // APIs are not to be trusted so we wrap interaction with data from API in try/catch
        try {
            view.showName(hit.getUser());
            view.showSubLine(hit.getTags());
//            view.showStartTime(hit.getStartTimeFormatted());
//            view.showDescription(hit.getDescription());
            view.showImage(hit.getWebformatURL());
        } catch (Exception e) {
            String errorMessage = "Unknown error while using data from API!";
            Log.e(TAG, errorMessage, e);
            view.showError(errorMessage);
        }
    }

    @Override
    public void onImageSelected() {
        view.showImageInPhotoViewer(hit);
    }

    @Override
    public void cancel() {
        //no op
    }
}
