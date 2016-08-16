package com.leinardi.dagger2mvp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.leinardi.dagger2mvp.ui.hitlist.HitListActivity;

/**
 * The only purpose of this activity is to show something when the app is bootstrapping
 * (usually can be seen on slower devices)
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, HitListActivity.class));
        finish();
    }
}
