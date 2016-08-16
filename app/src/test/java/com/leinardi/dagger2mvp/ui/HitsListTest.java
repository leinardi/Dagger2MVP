package com.leinardi.dagger2mvp.ui;

import com.leinardi.dagger2mvp.BuildConfig;
import com.leinardi.dagger2mvp.R;
import com.leinardi.dagger2mvp.ui.hitlist.HitListActivity;

import org.assertj.android.appcompat.v7.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class HitsListTest {

    private HitListActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(HitListActivity.class)
                .create()
                .start()
                .resume()
                .visible()
                .get();
    }

    @Test
    public void title_isCorrect() throws Exception {
        Assertions.assertThat(activity.getSupportActionBar()).hasTitle(R.string.app_name);
    }

    @Ignore("This test was not writted due to lack of time. This is what should have been done:\n" +
            "Since this feature involves network calls, to properly unit test this it, is necessary\n" +
            "to mock the Network module and provide a fake JSON response. This way the test doesn't\n" +
            "rely on an internet connection, a web service and the JSON response is always the same.\n" +
            "Once we have that it is possible tu use assertj-android to check if the data inside the\n" +
            "RecyclerView is the same as what we expecting from the JSON.")
    @Test
    public void hitList_isCorrect() {
        // TODO write me
    }
}