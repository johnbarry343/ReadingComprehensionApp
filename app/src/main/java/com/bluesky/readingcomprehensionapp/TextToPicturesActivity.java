package com.bluesky.readingcomprehensionapp;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_to_pic);
        text = (TextView) findViewById(R.id.text);
        imageButtonUpperLeft = (ImageButton) findViewById(R.id.imageButtonUpperLeft);
        imageButtonUpperLeft.setOnClickListener(this);
        imageButtonUpperRight = (ImageButton) findViewById(R.id.imageButtonUpperRight);
        imageButtonUpperRight.setOnClickListener(this);
        imageButtonLowerLeft = (ImageButton) findViewById(R.id.imageButtonLowerLeft);
        imageButtonLowerLeft.setOnClickListener(this);
        imageButtonLowerRight = (ImageButton) findViewById(R.id.imageButtonLowerRight);
        imageButtonLowerRight.setOnClickListener(this);
        drawNewProblem();
    }

    private String[] obtainData()
    {
        return DatabaseHelper.getInstance(this).getData(1);
    }

    void drawNewProblem() {
        Resources res = this.getResources();
        int imageId;
        String[] dataArray = DatabaseHelper.getInstance(getApplicationContext()).getData(1);
        correctString = dataArray[0];
        for (int i = 0; i < 4; i++) {
            data.add(dataArray[i]);
        }
        Collections.shuffle(data);
        imageId = res.getIdentifier(data.get(0), "drawable", this.getPackageName());
        if (data.get(0).equals(correctString)) correctAnswer = R.id.imageButtonUpperLeft;
        imageButtonUpperLeft.setImageResource(imageId);
        imageId = res.getIdentifier(data.get(1), "drawable", this.getPackageName());
        if (data.get(1).equals(correctString)) correctAnswer = R.id.imageButtonUpperRight;
        imageButtonUpperRight.setImageResource(imageId);
        imageId = res.getIdentifier(data.get(2), "drawable", this.getPackageName());
        if (data.get(2).equals(correctString)) correctAnswer = R.id.imageButtonLowerLeft;
        imageButtonLowerLeft.setImageResource(imageId);
        imageId = res.getIdentifier(data.get(3), "drawable", this.getPackageName());
        if (data.get(3).equals(correctString)) correctAnswer = R.id.imageButtonLowerRight;
        imageButtonLowerRight.setImageResource(imageId);

    }

    @Override
    public void onClick(View view)
    {

    }
}
