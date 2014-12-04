package com.bluesky.readingcomprehensionapp;

import android.app.Activity;
import android.content.res.Resources;
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
    LayoutInflater inflater;
    String[] dataArray = {"right_answer_alert_dialog_icon", "ic_launcher", "sound_icon", "wrong_answer_toast_icon"};
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
        for (int i = 0; i < 4; i++) {
            data.add(dataArray[i]);
        }
        drawNewProblem();
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
            case R.id.imageButton: {
                // play the sound file for this problem
                Toast.makeText(this,
                        "Play sound.",
                        Toast.LENGTH_SHORT).show();
                break;
            }
        }
        gotItRight = true;
        if (!gotItRight) {
            ActivityUtilities.wrongAnswerToast(this, inflater);
        } else {
            ActivityUtilities.rightAnswerAlertDialog(this, "bear");
            drawNewProblem();
        }
    }

    void drawNewProblem() {
        //draw new problem. Need to store the button ID of the correct answer in correctAnswer
//        String[] data = DatabaseHelper.getInstance(getApplicationContext()).getData(1);
        //need the resources for the strings
        Resources res = this.getResources();
        int imageId;

        Collections.shuffle(data);
        imageId = res.getIdentifier(data.get(0), "drawable", this.getPackageName());
        imageButton5.setImageResource(imageId);
        imageId = res.getIdentifier(data.get(1), "drawable", this.getPackageName());
        imageButton6.setImageResource(imageId);
        imageId = res.getIdentifier(data.get(2), "drawable", this.getPackageName());
        imageButton8.setImageResource(imageId);
        imageId = res.getIdentifier(data.get(3), "drawable", this.getPackageName());
        imageButton9.setImageResource(imageId);

    }
}
