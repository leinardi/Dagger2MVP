package com.leinardi.dagger2mvp.ui.photoviewer;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.leinardi.dagger2mvp.AppComponent;
import com.leinardi.dagger2mvp.R;
import com.leinardi.dagger2mvp.model.Hit;
import com.leinardi.dagger2mvp.ui.base.BaseActivity;
import com.leinardi.dagger2mvp.ui.hitdetail.HitDetailActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;


public class PhotoViewerActivity extends BaseActivity implements PhotoViewerView {
    @BindView(R.id.iv_photo)
    PhotoView photoView;

    @Inject
    PhotoViewerPresenter presenter;

    @Override
    protected void injectDependencies(AppComponent appComponent) {
        appComponent.plus(new PhotoViewerModule(this)).inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_viewer);
        ButterKnife.bind(this);

        Bundle args = getIntent().getExtras();
        if (args == null || !args.containsKey(HitDetailActivity.ARG_ITEM)) {
            throw new IllegalArgumentException("Invalid Fragment arguments");
        }

        final Hit hit = getIntent().getParcelableExtra(HitDetailActivity.ARG_ITEM);
        presenter.loadhitImage(hit);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(String title) {
        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    @Override
    public void setSubtitle(String subtitle) {
        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setSubtitle(subtitle);
        }
    }

    @Override
    public void showImage(String url) {
        final PhotoViewAttacher attacher = new PhotoViewAttacher(photoView);

        Glide.with(this)
                .load(url)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        attacher.update();
                        return false;
                    }
                })
                .into(photoView);
    }
}
