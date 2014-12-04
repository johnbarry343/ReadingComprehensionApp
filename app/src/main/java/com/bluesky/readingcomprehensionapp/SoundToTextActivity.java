package com.bluesky.readingcomprehensionapp;

import android.content.Context;
import android.media.AudioManager;
import android.app.Activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.media.SoundPool.OnLoadCompleteListener;
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
    String correct;
    String wrongOne;
    String wrongTwo;
    String wrongThree;

    public void setButtons() {
        //String[] data = DatabaseHelper.getInstance(getApplicationContext()).getData(1);
        // ^ gets string
        correct = "bear";
        // ^ gets right answer
        int correctId = this.getResources().getIdentifier(correct, "raw", this.getPackageName());
        // ^ uses that grab the identifier for the corresponding sound file from db name
        Button one = (Button) this.findViewById(R.id.testButton);
        final MediaPlayer mp = MediaPlayer.create(this, correctId);
        one.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                mp.start();
            }
        });}
    // sets the replay button to the right sound


    // wrongOne = data [2];
    //wrongTwo = data [3];
    //wrongThree = data [4];    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sound_to_word);

        setButtons();


    }

}







