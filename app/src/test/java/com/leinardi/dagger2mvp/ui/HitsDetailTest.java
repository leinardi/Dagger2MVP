package com.leinardi.dagger2mvp.ui;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.widget.TextView;

import com.leinardi.dagger2mvp.BuildConfig;
import com.leinardi.dagger2mvp.R;
import com.leinardi.dagger2mvp.model.Hit;
import com.leinardi.dagger2mvp.ui.hitdetail.HitDetailActivity;
import com.leinardi.dagger2mvp.util.TestUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import static org.assertj.android.api.Assertions.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class HitsDetailTest {

    private HitDetailActivity activity;

    @Before
    public void setUp() throws Exception {
        Hit hit = TestUtils.getTestHit();

        Intent intent = new Intent(ShadowApplication.getInstance().getApplicationContext(), HitDetailActivity.class);
        intent.putExtra(HitDetailActivity.ARG_ITEM, hit);
        activity = Robolectric.buildActivity(HitDetailActivity.class)
                .withIntent(intent)
                .create()
                .start()
                .resume()
                .visible()
                .get();
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidFragmentArgument_Exception() {
        Robolectric.buildActivity(HitDetailActivity.class)
                .create()
                .start()
                .resume()
                .visible()
                .get();
    }

    @Test
    public void name_isCorrect() throws Exception {
        Hit hit = TestUtils.getTestHit();

        String title = ((CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout)).getTitle().toString();
//        Assert.assertTrue(title.equals(hit.getName())); // TODO: 29/07/16  
    }

    @Test
    public void subLine_isCorrect() throws Exception {
        Hit hit = TestUtils.getTestHit();

        TextView textView = ((TextView) activity.findViewById(R.id.sub_line));
        assertThat(textView).isVisible();
//        assertThat(textView).hasTextString(hit.getSubline()); // TODO: 29/07/16  
    }


    @Test
    public void startTime_isCorrect() throws Exception {
        Hit hit = TestUtils.getTestHit();

        TextView textView = ((TextView) activity.findViewById(R.id.start_time));
        assertThat(textView).isVisible();
//        assertThat(textView).hasTextString(hit.getStartTimeFormatted()); // TODO: 29/07/16  
    }


    @Test
    public void description_isCorrect() throws Exception {
        Hit hit = TestUtils.getTestHit();

        TextView textView = ((TextView) activity.findViewById(R.id.description));
        assertThat(textView).isVisible();
//        assertThat(textView).hasTextString(hit.getDescription()); // TODO: 29/07/16  
    }

}