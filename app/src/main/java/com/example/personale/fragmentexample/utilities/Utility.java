package com.example.personale.fragmentexample.utilities;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.example.personale.fragmentexample.R;
import com.example.personale.fragmentexample.activities.MainActivity;

/**
 * Created by personale on 06/04/2017.
 */

public class Utility {

    public static void setStatusBar(Activity activity, int color) {
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
            activity.getWindow().setStatusBarColor(color);
        } else {
            Toast.makeText(activity.getApplicationContext(), "Old version, please update!", Toast.LENGTH_SHORT).show();
        }
    }

    public static void setToolbar(ActionBar ab, int color) {
        ab.setBackgroundDrawable(new ColorDrawable(color));
    }

    public static void disableMenu(Activity a) {
        ((MainActivity)a).getMenu().getItem(0).setVisible(false);
    }
}
