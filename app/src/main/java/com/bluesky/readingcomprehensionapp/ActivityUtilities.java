package com.bluesky.readingcomprehensionapp;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Tim on 12/3/2014.
 */
public class ActivityUtilities {

    static void wrongAnswerToast(Activity cc, LayoutInflater li) {
        View layout = li.inflate(R.layout.wrong_answer_toast,
                (ViewGroup) cc.findViewById(R.id.toast_layout_root));

        Toast toast = new Toast(cc);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

}
