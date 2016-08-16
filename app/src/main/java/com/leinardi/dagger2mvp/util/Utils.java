package com.leinardi.dagger2mvp.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by leinardi on 13/07/16.
 */

public class Utils {

    public static boolean isNetworkActive(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
}
