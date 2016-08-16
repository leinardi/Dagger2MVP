package com.leinardi.dagger2mvp.ui;

import android.content.Intent;

import com.leinardi.dagger2mvp.BuildConfig;
import com.leinardi.dagger2mvp.model.Hit;
import com.leinardi.dagger2mvp.ui.hitdetail.HitDetailActivity;
import com.leinardi.dagger2mvp.ui.photoviewer.PhotoViewerActivity;
import com.leinardi.dagger2mvp.util.TestUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class PhotoViewerTest {

    private PhotoViewerActivity activity;

    @Before
    public void setUp() throws Exception {
        Hit hit = TestUtils.getTestHit();

        Intent intent = new Intent(ShadowApplication.getInstance().getApplicationContext(), PhotoViewerActivity.class);
        intent.putExtra(HitDetailActivity.ARG_ITEM, hit);
        activity = Robolectric.buildActivity(PhotoViewerActivity.class)
                .withIntent(intent)
                .create()
                .start()
                .resume()
                .visible()
                .get();
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidFragmentArgument_Exception() {
        Robolectric.buildActivity(PhotoViewerActivity.class)
                .create()
                .start()
                .resume()
                .visible()
                .get();
    }

    @Test
    public void name_isCorrect() throws Exception {
        Hit hit = TestUtils.getTestHit();

//        assertThat(activity.getSupportActionBar()).hasTitle(hit.get()); // TODO: 29/07/16
    }

    @Test
    public void subLine_isCorrect() throws Exception {
        Hit hit = TestUtils.getTestHit();

//        assertThat(activity.getSupportActionBar()).hasSubtitle(hit.getSubline()); // TODO: 29/07/16
    }

}