package com.leinardi.dagger2mvp.ui.hitlist;

import com.leinardi.dagger2mvp.model.Hits;
import com.leinardi.dagger2mvp.network.retrofit.PixabayServer;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by leinardi on 13/07/16.
 */

public class HitListInteractorImpl implements HitListInteractor {


    private PixabayServer pixabayServer;

    private Subscription subscription;

    @Inject
    public HitListInteractorImpl(PixabayServer pixabayServer) {
        this.pixabayServer = pixabayServer;
    }

    @Override
    public void cancel() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    @Override
    public void reset() {
        cancel();
    }

    @Override
    public void loadhitList(final HitListListener hitListListener) {
        reset();
        subscription = pixabayServer.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Hits>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        hitListListener.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(Hits hits) {
                        hitListListener.onSuccess(hits);
                    }
                });
    }
}
