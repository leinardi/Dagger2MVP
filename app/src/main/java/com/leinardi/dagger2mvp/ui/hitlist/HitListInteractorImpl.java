package com.leinardi.dagger2mvp.ui.hitlist;

import com.leinardi.dagger2mvp.model.Hits;
import com.leinardi.dagger2mvp.network.retrofit.PixabayServer;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by leinardi on 13/07/16.
 */

public class HitListInteractorImpl implements HitListInteractor {


    private PixabayServer pixabayServer;

    private boolean isCanceled;

    @Inject
    public HitListInteractorImpl(PixabayServer pixabayServer) {
        this.pixabayServer = pixabayServer;
    }

    @Override
    public void cancel() {
        isCanceled = true;
    }

    @Override
    public void reset() {
        isCanceled = false;
    }

    @Override
    public void loadhitList(final HitListListener hitListListener) {
        reset();
        pixabayServer.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Hits>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (!isCanceled) {
                            hitListListener.onFailure(e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(Hits hits) {
                        if (!isCanceled) {
                            hitListListener.onSuccess(hits);
                        }
                    }
                });
    }
}
