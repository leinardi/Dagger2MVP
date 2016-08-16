package com.leinardi.dagger2mvp.ui.hitdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.leinardi.dagger2mvp.AppComponent;
import com.leinardi.dagger2mvp.R;
import com.leinardi.dagger2mvp.model.Hit;
import com.leinardi.dagger2mvp.ui.base.BaseActivity;
import com.leinardi.dagger2mvp.ui.photoviewer.PhotoViewerActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * An activity representing a single Hits detail screen.
 */
public class HitDetailActivity extends BaseActivity implements HitDetailView {

    public static final String ARG_ITEM = "hit_item";

    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    @BindView(R.id.detail_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.imageView)
    ImageView mCollapsingToolbarImageView;

    @BindView(R.id.sub_line)
    AppCompatTextView mSubLine;

    @BindView(R.id.start_time)
    AppCompatTextView mStartTime;

    @BindView(R.id.description)
    AppCompatTextView mDescription;

    @Inject
    protected HitDetailPresenter presenter;

    @Override
    protected void injectDependencies(AppComponent appComponent) {
        appComponent.plus(new HitDetailModule(this)).inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hit_detail);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        Bundle args = getIntent().getExtras();
        if (args == null || !args.containsKey(ARG_ITEM)) {
            throw new IllegalArgumentException("Invalid Fragment arguments");
        }

        final Hit hit = getIntent().getParcelableExtra(ARG_ITEM);
        presenter.loadHitDetail(hit);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    @OnClick(R.id.fab)
    public void onImageFloatingActionButtonPressed() {
        presenter.onImageSelected();
    }

    @Override
    public void showName(String name) {
        mCollapsingToolbarLayout.setTitle(name);
    }

    @Override
    public void showSubLine(String subLine) {
        mSubLine.setText(subLine);
    }

    @Override
    public void showStartTime(String startTime) {
        mStartTime.setText(startTime);
    }

    @Override
    public void showDescription(String description) {
        mDescription.setText(description);
    }

    @Override
    public void showImage(String url) {
        Glide.with(this)
                .load(url)
                .centerCrop()
                .crossFade()
                .into(mCollapsingToolbarImageView);
    }

    @Override
    public void showImageInPhotoViewer(Hit hit) {
        startPhotoViewerActivity(hit);
    }

    private void startPhotoViewerActivity(Hit hits) {
        Intent intent = new Intent(HitDetailActivity.this, PhotoViewerActivity.class);
        intent.putExtra(ARG_ITEM, hits);

        startActivity(intent);
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
    protected void onDestroy() {
        presenter.cancel();
        super.onDestroy();
    }
}
