package com.leinardi.dagger2mvp.ui.photoviewer;

import android.util.Log;

import com.leinardi.dagger2mvp.model.Hit;

import javax.inject.Inject;

/**
 * Created by leinardi on 13/07/16.
 */

public class PhotoViewerPresenterImpl implements PhotoViewerPresenter {
    private static final String TAG = PhotoViewerPresenterImpl.class.getSimpleName();
    private final PhotoViewerView view;

    @Inject
    public PhotoViewerPresenterImpl(PhotoViewerView photoViewerView) {
        this.view = photoViewerView;
    }

    @Override
    public void loadhitImage(Hit hit) {
        // APIs are not to be trusted so we wrap interaction with data from API in try/catch
        try {
            view.setTitle(hit.getUser());
            view.setSubtitle(hit.getTags());
            view.showImage(hit.getWebformatURL());
        } catch (Exception e) {
            String errorMessage = "Unknown error while using data from API!";
            Log.e(TAG, errorMessage, e);
            view.showError(errorMessage);
        }
    }

    @Override
    public void cancel() {
        //no op
    }
}
