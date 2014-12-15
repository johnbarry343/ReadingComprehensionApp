package com.bluesky.readingcomprehensionapp;

import android.app.Activity;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
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
    ImageView wrongAnswerImageView;
    int correctAnswer = 0;
    String correctString = "";
    LayoutInflater inflater;
    MediaPlayer mp = new MediaPlayer();
    ArrayList<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sound_to_pic);
        wrongAnswerImageView = (ImageView) findViewById(R.id.imageView);
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
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
      /*  data.clear();
        String aString = "";
        CharSequence gameState[] = {"", "", "", "", ""};
        gameState = savedInstanceState.getCharSequenceArray("gameState");
        for (int i = 0; i < 4; i++)  {
            aString = (String) gameState[i];
            data.add(aString);
        }
        correctString = (String) gameState[4];
        drawProblem(data);*/
        if (savedInstanceState.getInt("isWrongAnswerGiven") == View.VISIBLE)
        {
            wrongAnswerImageView.setVisibility(View.VISIBLE);
        }
        else
        {
            wrongAnswerImageView.setVisibility(View.INVISIBLE);
        }
        int imageButtonUpperLeftId = savedInstanceState.getInt("imageButtonUpperLeftImage");
        imageButton5.setImageResource(imageButtonUpperLeftId);
        int imageButtonUpperRightId = savedInstanceState.getInt("imageButtonUpperRightImage");
        imageButton6.setImageResource(imageButtonUpperRightId);
        int imageButtonLowerLeftId = savedInstanceState.getInt("imageButtonLowerLeftImage");
        imageButton8.setImageResource(imageButtonLowerLeftId);
        int imageButtonLowerRightId = savedInstanceState.getInt("imageButtonLowerRightImage");
        imageButton9.setImageResource(imageButtonLowerRightId);
        int  soundImageButtonID = savedInstanceState.getInt("soundImageButtonID");
        soundImageButton.setImageResource(soundImageButtonID);

        correctAnswer = savedInstanceState.getInt("correctAnswer");
        correctString = savedInstanceState.getString("correctString");
       // text.setText(correctString);
        data.add(savedInstanceState.getString("data0"));
        data.add(savedInstanceState.getString("data1"));
        data.add(savedInstanceState.getString("data2"));
        data.add(savedInstanceState.getString("data3"));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
       /* CharSequence gameState[] = {"", "", "", "", ""};
        for (int i = 0; i < 4; i++) {
            gameState[i] = data.get(i);
        }
        gameState[4] = correctString;
        outState.putCharSequenceArray("gameState", gameState);*/

        outState.putInt("imageButtonUpperLeftImage", getResources().getIdentifier(data.get(0), "drawable", getPackageName()));
        outState.putInt("imageButtonUpperRightImage", getResources().getIdentifier(data.get(1), "drawable", getPackageName()));
        outState.putInt("imageButtonLowerLeftImage", getResources().getIdentifier(data.get(2), "drawable", getPackageName()));
        outState.putInt("imageButtonLowerRightImage", getResources().getIdentifier(data.get(3), "drawable", getPackageName()));
       outState.putInt("soundImageButton",getResources().getIdentifier(correctString, "raw", this.getPackageName()));
        outState.putString("data0", data.get(0));
        outState.putString("data1", data.get(1));
        outState.putString("data2", data.get(2));
        outState.putString("data3", data.get(3));
        outState.putInt("correctAnswer", correctAnswer);
        outState.putString("correctString", correctString);
        outState.putInt("isWrongAnswerGiven", wrongAnswerImageView.getVisibility());
    }

    @Override
    public void onClick(View v) {
        wrongAnswerImageView.setVisibility(View.INVISIBLE);
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
//                ActivityUtilities.wrongAnswerToast(this, inflater);
                wrongAnswerImageView.setVisibility(View.VISIBLE);
            } else {
                ActivityUtilities.rightAnswerAlertDialog(this, correctString);
                drawNewProblem();
            }
        }
    }

    void drawProblem(ArrayList<String> theData) {
        Resources res = this.getResources();
        int imageId;
        wrongAnswerImageView.setVisibility(View.INVISIBLE);
        imageId = res.getIdentifier(theData.get(0), "drawable", this.getPackageName());
        if (theData.get(0).equals(correctString)) correctAnswer = R.id.imageButton5;
        imageButton5.setImageResource(imageId);
        imageId = res.getIdentifier(theData.get(1), "drawable", this.getPackageName());
        if (theData.get(1).equals(correctString)) correctAnswer = R.id.imageButton6;
        imageButton6.setImageResource(imageId);
        imageId = res.getIdentifier(theData.get(2), "drawable", this.getPackageName());
        if (theData.get(2).equals(correctString)) correctAnswer = R.id.imageButton8;
        imageButton8.setImageResource(imageId);
        imageId = res.getIdentifier(theData.get(3), "drawable", this.getPackageName());
        if (theData.get(3).equals(correctString)) correctAnswer = R.id.imageButton9;
        imageButton9.setImageResource(imageId);
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
        drawProblem(data);
    }
}
