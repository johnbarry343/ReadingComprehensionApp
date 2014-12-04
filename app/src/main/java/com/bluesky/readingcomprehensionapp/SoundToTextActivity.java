package com.bluesky.readingcomprehensionapp;

import android.content.Context;
import android.app.Activity;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.media.SoundPool.OnLoadCompleteListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

import com.bluesky.readingcomprehensionapp.R;

import static android.view.View.OnTouchListener;


/**
 * Created by Tim on 12/2/2014.
 * edited by Jon - 12/2/2014.
 */


public class SoundToTextActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.sound_to_word);

    }



}