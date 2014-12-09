package com.bluesky.readingcomprehensionapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Created by Tim on 12/2/2014.to
 */
public class PictureToTextActivity extends Activity implements View.OnClickListener {

    private ImageView image;
    private int correctAnswer = 0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    LayoutInflater inflater;


    String correctString = "";
    ArrayList<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.pic_to_word);
        image = (ImageView) findViewById(R.id.Image);
        button1 = (Button) findViewById(R.id.Button1);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.Button2);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.Button3);
        button3.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.Button4);
        button4.setOnClickListener(this);
        inflater = getLayoutInflater();

        drawNewProblem();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        outState.putString("button1", data.get(0));
        outState.putString("button2", data.get(1));
        outState.putString("button3", data.get(2));
        outState.putString("button4", data.get(3));
        outState.putString("data0", data.get(0));
        outState.putString("data1", data.get(1));
        outState.putString("data2", data.get(2));
        outState.putString("data3", data.get(3));

        outState.putInt("correctAnswer", correctAnswer);
        outState.putString("correctString", correctString);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {


        String button1Id = savedInstanceState.getString("button1");
        button1.setText(button1Id);

        String button2Id = savedInstanceState.getString("button2");
        button2.setText(button2Id);

        String button3Id = savedInstanceState.getString("button3");
        button3.setText(button3Id);

        String button4Id = savedInstanceState.getString("button4");
        button4.setText(button4Id);


        correctAnswer = savedInstanceState.getInt("correctAnswer");
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



        for (int i = 0; i < 4; i++)
        {
            data.add(dataArray[i]);
        }
        Collections.shuffle(data);



        button1.setText(data.get(0));

        imageId = getResources().getIdentifier(data.get(0), "drawable", getPackageName());
        if (data.get(0).equals(correctString))
        {
            correctAnswer = R.id.buttonOne;

        }

        button2.setText(data.get(1));
        imageId = getResources().getIdentifier(data.get(1), "drawable", getPackageName());
        if (data.get(1).equals(correctString))
        {
            correctAnswer = R.id.buttonTwo;
        }
        button3.setText(data.get(2));
        imageId = getResources().getIdentifier(data.get(2), "drawable", getPackageName());
        if (data.get(2).equals(correctString))
        {
            correctAnswer = R.id.buttonThree  ;
        }
        button4.setText(data.get(3));
        imageId = getResources().getIdentifier(data.get(3), "drawable", getPackageName());
        if (data.get(3).equals(correctString))
        {
            correctAnswer = R.id.buttonFour;
        }

        int correctId = this.getResources().getIdentifier(correctString, "raw", this.getPackageName());


    }

    @Override
    public void onClick(View v) {
        boolean gotItRight = false;
        boolean listen = false;
        int vid = v.getId();
        switch (vid){
            case R.id.Button1:{
                if (R.id.Button1 == correctAnswer) gotItRight = true;
                break;
            }
            case R.id.Button2:{
                if (R.id.Button2 == correctAnswer) gotItRight = true;
                break;
            }
            case R.id.Button3:{
                if (R.id.Button3 == correctAnswer) gotItRight = true;
                break;
            }
            case R.id.Button4:{
                if (R.id.Button4 == correctAnswer) gotItRight = true;
            }
        }
            if (!listen){
                if (!gotItRight){
                    ActivityUtilities.wrongAnswerToast(this, inflater);
                }else{
                    ActivityUtilities.rightAnswerAlertDialog(this, correctString);
                    drawNewProblem();
                }
            }
    }











}
