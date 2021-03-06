package com.bluesky.readingcomprehensionapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Tim on 12/2/2014.
 */
public class TextToPicturesActivity extends Activity implements View.OnClickListener
{

    private ArrayList<String> data = new ArrayList<String>();
    private TextView text;
    private ImageButton imageButtonUpperLeft;
    private ImageButton imageButtonUpperRight;
    private ImageButton imageButtonLowerLeft;
    private ImageButton imageButtonLowerRight;
    private String correctString;
    private int correctAnswer = 0;
    ImageView wrongAnswerImageView;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_to_pic);
        wrongAnswerImageView = (ImageView) findViewById(R.id.imageView);
        text = (TextView) findViewById(R.id.text);
        imageButtonUpperLeft = (ImageButton) findViewById(R.id.imageButtonUpperLeft);
        imageButtonUpperLeft.setOnClickListener(this);
        imageButtonUpperRight = (ImageButton) findViewById(R.id.imageButtonUpperRight);
        imageButtonUpperRight.setOnClickListener(this);
        imageButtonLowerLeft = (ImageButton) findViewById(R.id.imageButtonLowerLeft);
        imageButtonLowerLeft.setOnClickListener(this);
        imageButtonLowerRight = (ImageButton) findViewById(R.id.imageButtonLowerRight);
        imageButtonLowerRight.setOnClickListener(this);
        inflater = getLayoutInflater();
        if (savedInstanceState == null)
        {
            drawNewProblem();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        outState.putInt("imageButtonUpperLeftImage", getResources().getIdentifier(data.get(0), "drawable", getPackageName()));
        outState.putInt("imageButtonUpperRightImage", getResources().getIdentifier(data.get(1), "drawable", getPackageName()));
        outState.putInt("imageButtonLowerLeftImage", getResources().getIdentifier(data.get(2), "drawable", getPackageName()));
        outState.putInt("imageButtonLowerRightImage", getResources().getIdentifier(data.get(3), "drawable", getPackageName()));
        outState.putString("data0", data.get(0));
        outState.putString("data1", data.get(1));
        outState.putString("data2", data.get(2));
        outState.putString("data3", data.get(3));
        outState.putInt("correctAnswer", correctAnswer);
        outState.putString("correctString", correctString);
        outState.putInt("isWrongAnswerGiven", wrongAnswerImageView.getVisibility());
        super.onSaveInstanceState(outState);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        if (savedInstanceState.getInt("isWrongAnswerGiven") == View.VISIBLE)
        {
            wrongAnswerImageView.setVisibility(View.VISIBLE);
        }
        else
        {
            wrongAnswerImageView.setVisibility(View.INVISIBLE);
        }
        int imageButtonUpperLeftId = savedInstanceState.getInt("imageButtonUpperLeftImage");
        imageButtonUpperLeft.setImageResource(imageButtonUpperLeftId);
        int imageButtonUpperRightId = savedInstanceState.getInt("imageButtonUpperRightImage");
        imageButtonUpperRight.setImageResource(imageButtonUpperRightId);
        int imageButtonLowerLeftId = savedInstanceState.getInt("imageButtonLowerLeftImage");
        imageButtonLowerLeft.setImageResource(imageButtonLowerLeftId);
        int imageButtonLowerRightId = savedInstanceState.getInt("imageButtonLowerRightImage");
        imageButtonLowerRight.setImageResource(imageButtonLowerRightId);
        correctAnswer = savedInstanceState.getInt("correctAnswer");
        correctString = savedInstanceState.getString("correctString");
        text.setText(correctString);
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
        wrongAnswerImageView.setVisibility(View.INVISIBLE);
        String[] dataArray = DatabaseHelper.getInstance(getApplicationContext()).getData(1);
        correctString = dataArray[0];
        text.setText(correctString);
        for (int i = 0; i < 4; i++)
        {
            data.add(dataArray[i]);
        }
        Collections.shuffle(data);
        imageId = getResources().getIdentifier(data.get(0), "drawable", getPackageName());
        if (data.get(0).equals(correctString))
        {
            correctAnswer = R.id.imageButtonUpperLeft;
        }
        imageButtonUpperLeft.setImageResource(imageId);
        imageId = getResources().getIdentifier(data.get(1), "drawable", getPackageName());
        if (data.get(1).equals(correctString))
        {
            correctAnswer = R.id.imageButtonUpperRight;
        }
        imageButtonUpperRight.setImageResource(imageId);
        imageId = getResources().getIdentifier(data.get(2), "drawable", getPackageName());
        if (data.get(2).equals(correctString))
        {
            correctAnswer = R.id.imageButtonLowerLeft;
        }
        imageButtonLowerLeft.setImageResource(imageId);
        imageId = getResources().getIdentifier(data.get(3), "drawable", getPackageName());
        if (data.get(3).equals(correctString))
        {
            correctAnswer = R.id.imageButtonLowerRight;
        }
        imageButtonLowerRight.setImageResource(imageId);

    }

    @Override
    public void onClick(View v) {
        wrongAnswerImageView.setVisibility(View.INVISIBLE);
        boolean gotItRight = false;
        boolean listen = false;
        int vid = v.getId();
        switch (vid) {
            case R.id.imageButtonUpperRight: {
                if (R.id.imageButtonUpperRight == correctAnswer) gotItRight = true;
                break;
            }
            case R.id.imageButtonUpperLeft: {
                if (R.id.imageButtonUpperLeft == correctAnswer) gotItRight = true;
                break;
            }
            case R.id.imageButtonLowerLeft: {
                if (R.id.imageButtonLowerLeft == correctAnswer) gotItRight = true;
                break;
            }
            case R.id.imageButtonLowerRight: {
                if (R.id.imageButtonLowerRight == correctAnswer) gotItRight = true;
                break;
            }
        }

        if (!listen) {
            if (!gotItRight) {
                wrongAnswerImageView.setVisibility(View.VISIBLE);
            } else {
                wrongAnswerImageView.setVisibility(View.GONE);
                ActivityUtilities.rightAnswerAlertDialog(this, correctString);
                drawNewProblem();
            }
        }
    }
}
