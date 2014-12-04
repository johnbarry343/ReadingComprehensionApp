package com.bluesky.readingcomprehensionapp;

import android.app.Activity;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bluesky.readingcomprehensionapp.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Tim on 12/2/2014. again
 */
public class SoundToPictureActivity extends Activity implements View.OnClickListener {

    ImageButton imageButton5, imageButton6, imageButton8, imageButton9, soundImageButton;
    int correctAnswer = 0;
    String correctString = "";
    LayoutInflater inflater;
    MediaPlayer mp = new MediaPlayer();
    ArrayList<String> data = new ArrayList<String>();

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
        soundImageButton = (ImageButton) findViewById(R.id.imageButton);
        soundImageButton.setOnClickListener(this);
        inflater = getLayoutInflater();

        drawNewProblem();
    }

    @Override
    public void onClick(View v) {
        boolean gotItRight = false;
        boolean listen = false;
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
            case R.id.imageButton: {
                listen = true;
                int correctId = this.getResources().getIdentifier(correctString, "raw", this.getPackageName());
                mp = MediaPlayer.create(this, correctId);
                mp.start();
                break;
            }
        }
        if (!listen) {
            if (!gotItRight) {
                ActivityUtilities.wrongAnswerToast(this, inflater);
            } else {
                ActivityUtilities.rightAnswerAlertDialog(this, correctString);
                drawNewProblem();
            }
        }
    }

    void drawNewProblem() {
        Resources res = this.getResources();
        int imageId;
        data.clear();
        String[] dataArray = DatabaseHelper.getInstance(getApplicationContext()).getData(1);
        correctString = dataArray[0];
        for (int i = 0; i < 4; i++) {
            data.add(dataArray[i]);
        }
        Collections.shuffle(data);
        imageId = res.getIdentifier(data.get(0), "drawable", this.getPackageName());
        if (data.get(0).equals(correctString)) correctAnswer = R.id.imageButton5;
        imageButton5.setImageResource(imageId);
        imageId = res.getIdentifier(data.get(1), "drawable", this.getPackageName());
        if (data.get(1).equals(correctString)) correctAnswer = R.id.imageButton6;
        imageButton6.setImageResource(imageId);
        imageId = res.getIdentifier(data.get(2), "drawable", this.getPackageName());
        if (data.get(2).equals(correctString)) correctAnswer = R.id.imageButton8;
        imageButton8.setImageResource(imageId);
        imageId = res.getIdentifier(data.get(3), "drawable", this.getPackageName());
        if (data.get(3).equals(correctString)) correctAnswer = R.id.imageButton9;
        imageButton9.setImageResource(imageId);
    }
}
