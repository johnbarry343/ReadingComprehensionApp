package com.bluesky.readingcomprehensionapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Tim on 12/2/2014.
 */
public class SoundToTextActivity extends Activity implements View.OnClickListener
{

    private ArrayList<String> data = new ArrayList<String>();

    private ImageButton imageButton;
    // EAR BUTTON
    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    private String correctString;
    private int correctId;
    private int correctAnswer = 0;
    private String correct;
    MediaPlayer mp = new MediaPlayer();
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sound_to_word);

        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(this);
        buttonOne = (Button) findViewById(R.id.buttonOne);
        buttonOne.setOnClickListener(this);
        buttonTwo = (Button) findViewById(R.id.buttonTwo);
        buttonTwo.setOnClickListener(this);
        buttonThree = (Button) findViewById(R.id.buttonThree);
        buttonThree.setOnClickListener(this);
        buttonFour = (Button) findViewById(R.id.buttonFour);
        buttonFour.setOnClickListener(this);
        inflater = getLayoutInflater();
        drawNewProblem();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        outState.putString("buttonOne", data.get(0));
        outState.putString("buttonTwo", data.get(1));
        outState.putString("buttonThree", data.get(2));
        outState.putString("buttonFour", data.get(3));
       // outState.putInt("correctId", this.getResources().getIdentifier(correctString, "raw", this.getPackageName()));
        //  outState.putInt("buttonTwo", getResources().getIdentifier(data.get(1), "string", getPackageName()));
        //outState.putInt("buttonThree", getResources().getIdentifier(data.get(2), "string", getPackageName()));
        //outState.putInt("buttonFour", getResources().getIdentifier(data.get(3), "string", getPackageName()));
       outState.putString("data0", data.get(0));
      outState.putString("data1", data.get(1));
      outState.putString("data2", data.get(2));
  outState.putString("data3", data.get(3));

        outState.putInt("correctAnswer", correctAnswer);
        outState.putString("correctString", correctString);
        super.onSaveInstanceState(outState);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {


        String buttonOneId = savedInstanceState.getString("buttonOne");
        buttonOne.setText(buttonOneId);

        String buttonTwoId = savedInstanceState.getString("buttonTwo");

        buttonTwo.setText(buttonTwoId);
        String buttonThreeId = savedInstanceState.getString("buttonThree");
        buttonThree.setText(buttonThreeId);

        String buttonFourId = savedInstanceState.getString("buttonFour");
        buttonFour.setText(buttonFourId);


        correctAnswer = savedInstanceState.getInt("correctAnswer");

      //  correctId = savedInstanceState.getInt("correctId");
        correctString = savedInstanceState.getString("correctString");


     data.add(savedInstanceState.getString("data0"));
        data.add(savedInstanceState.getString("data1"));
        data.add(savedInstanceState.getString("data2"));
        data.add(savedInstanceState.getString("data3"));

        super.onRestoreInstanceState(savedInstanceState);
    }

    private String[] obtainData()
    {
        return DatabaseHelper.getInstance(getApplicationContext()).getData(1);
    }

    void drawNewProblem()
    {
        int imageId;
        data.clear();
        String[] dataArray = DatabaseHelper.getInstance(getApplicationContext()).getData(1);
        correctString = dataArray[0];


        // SET AUDIO text.setText(correctString);
        for (int i = 0; i < 4; i++)
        {
            data.add(dataArray[i]);
        }
        Collections.shuffle(data);


        ////
        buttonOne.setText(data.get(0));

            imageId = getResources().getIdentifier(data.get(0), "drawable", getPackageName());
        if (data.get(0).equals(correctString))
        {
            correctAnswer = R.id.buttonOne;

        }

        buttonTwo.setText(data.get(1));
        imageId = getResources().getIdentifier(data.get(1), "drawable", getPackageName());
        if (data.get(1).equals(correctString))
        {
            correctAnswer = R.id.buttonTwo;
        }
        buttonThree.setText(data.get(2));
        imageId = getResources().getIdentifier(data.get(2), "drawable", getPackageName());
        if (data.get(2).equals(correctString))
        {
            correctAnswer = R.id.buttonThree  ;
        }
        buttonFour.setText(data.get(3));
        imageId = getResources().getIdentifier(data.get(3), "drawable", getPackageName());
        if (data.get(3).equals(correctString))
        {
            correctAnswer = R.id.buttonFour;
        }

        int correctId = this.getResources().getIdentifier(correctString, "raw", this.getPackageName());
        mp = MediaPlayer.create(this, correctId);
        //mp.start();

    }

    @Override
    public void onClick(View v) {
        boolean gotItRight = false;
        boolean listen = false;
        int vid = v.getId();
        switch (vid) {
            case R.id.buttonOne : {
                if (R.id.buttonOne == correctAnswer) gotItRight = true;
                break;
            }
            case R.id.buttonTwo: {
                if (R.id.buttonTwo  == correctAnswer) gotItRight = true;
                break;
            }
            case R.id.buttonThree  : {
                if (R.id.buttonThree  == correctAnswer) gotItRight = true;
                break;
            }
            case R.id.buttonFour  : {
                if (R.id.buttonFour == correctAnswer) gotItRight = true;
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
                ActivityUtilities.wrongTopLeft(this, inflater);
            } else {
                //THUMBS UP
                drawNewProblem();
            }
        }
    }
}
