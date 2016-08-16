package com.leinardi.dagger2mvp.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;

import com.leinardi.dagger2mvp.AppComponent;
import com.leinardi.dagger2mvp.Dagger2MvpApp;
import com.leinardi.dagger2mvp.R;
import com.leinardi.dagger2mvp.ui.dialog.ErrorAlertDialogFragment;

/**
 * Created by leinardi on 12/07/16.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    protected abstract void injectDependencies(AppComponent appComponent);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies(Dagger2MvpApp.getInstance().getApplicationComponent());
    }

    @Override
    public void showError(String message) {
        showErrorDialogFragment(message);
    }

    protected void showErrorDialogFragment(String message) {
        DialogFragment newFragment = ErrorAlertDialogFragment.newInstance(
                getString(R.string.error_alert_dialog_title), message);
        newFragment.show(getSupportFragmentManager(), ErrorAlertDialogFragment.class.getSimpleName());
    }
}
