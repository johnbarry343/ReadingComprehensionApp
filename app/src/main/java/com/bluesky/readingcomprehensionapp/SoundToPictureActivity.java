package com.bluesky.readingcomprehensionapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import com.bluesky.readingcomprehensionapp.R;

/**
 * Created by Tim on 12/2/2014. again
 */
public class SoundToPictureActivity extends Activity implements View.OnClickListener {
    //Tim is doing this one
    ImageButton imageButton5, imageButton6, imageButton8, imageButton9;
    int correctAnswer = 0;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sound_to_pic);
        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButton5.setOnClickListener(this);
        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton6.setOnClickListener(this);
        imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
        imageButton8.setOnClickListener(this);
        imageButton9 = (ImageButton) findViewById(R.id.imageButton9);
        imageButton9.setOnClickListener(this);
        inflater = getLayoutInflater();
        //draw new problem. Need to store the button ID of the correct answer in correctAnswer
    }

    @Override
    public void onClick(View v) {
        boolean gotItRight = false;
        int vid = v.getId();
        switch (vid) {
            case R.id.imageButton5: {
                if (R.id.imageButton5 == correctAnswer) gotItRight = true;
                break;
            }
            case R.id.imageButton6: {
                if (R.id.imageButton6 == correctAnswer) gotItRight = true;
                break;
            }
            case R.id.imageButton8: {
                if (R.id.imageButton8 == correctAnswer) gotItRight = true;
                break;
            }
            case R.id.imageButton9: {
                if (R.id.imageButton9 == correctAnswer) gotItRight = true;
                break;
            }
        }
        if ( !gotItRight ) ActivityUtilities.wrongAnswerToast(this, inflater);
    }
}
