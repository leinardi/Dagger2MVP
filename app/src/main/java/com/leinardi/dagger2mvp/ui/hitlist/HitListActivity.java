package com.leinardi.dagger2mvp.ui.hitlist;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ViewTreeObserver;

import com.leinardi.dagger2mvp.AppComponent;
import com.leinardi.dagger2mvp.R;
import com.leinardi.dagger2mvp.model.Hit;
import com.leinardi.dagger2mvp.ui.adapter.HitRecyclerViewAdapter;
import com.leinardi.dagger2mvp.ui.base.BaseActivity;
import com.leinardi.dagger2mvp.ui.hitdetail.HitDetailActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link HitDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class HitListActivity extends BaseActivity implements HitListView {

    private static final String TAG = HitListActivity.class.getSimpleName();

    @BindView(R.id.item_list)
    RecyclerView mRecyclerView;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Inject
    protected HitListPresenter presenter;

    @Override
    protected void injectDependencies(AppComponent appComponent) {
        appComponent.plus(new HitListModule(this)).inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hit_list);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        mToolbar.setTitle(getTitle());

        presenter.loadhitList();
    }

    private HitRecyclerViewAdapter.OnItemClickListener itemClickListener = new HitRecyclerViewAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(Hit hit) {
            presenter.onhitSelected(hit);
        }
    };

    private void setupRecyclerView(List<Hit> hitsList) {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.accent, R.color.primary);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadhitList();
            }
        });
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new HitRecyclerViewAdapter(hitsList, itemClickListener));

        mRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                findAndUseBestFitColumnNumber();
            }

            private void findAndUseBestFitColumnNumber() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    mRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    mRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                float recyclerViewWidth = mRecyclerView.getMeasuredWidth();
                float countdownCardMinimumWidth = getResources().getDimension(R.dimen.hit_card_minimum_width);

                int columnNumber = (int) Math.floor(recyclerViewWidth / countdownCardMinimumWidth);

                if (columnNumber > 0) {
                    mRecyclerView.setLayoutManager(new GridLayoutManager(HitListActivity.this, columnNumber, GridLayoutManager.VERTICAL, false));
                }
            }
        });
    }

    @Override
    public void showhits(List<Hit> hitList) {
        setupRecyclerView(hitList);
    }

    @Override
    public void showhitDetails(Hit hit) {
        startCampainDetailActivity(hit);
    }

    @Override
    public void startRefreshing() {
        mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void stopRefreshing() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    private void startCampainDetailActivity(Hit hits) {
        Intent intent = new Intent(HitListActivity.this, HitDetailActivity.class);
        intent.putExtra(HitDetailActivity.ARG_ITEM, hits);

        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        presenter.cancel();
        super.onDestroy();
    }
}
