package com.gulsum.onal.Helper;

import android.app.Activity;

import com.gulsum.onal.R;

public abstract class Utils {
    public static void back(Activity activity){
        activity.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
    public static void go(Activity activity){
        activity.overridePendingTransition(R.anim.slide_in_rigth, R.anim.slide_out_left);
    }
}
