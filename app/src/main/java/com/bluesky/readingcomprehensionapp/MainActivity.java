package com.bluesky.readingcomprehensionapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import bluesky.gc.com.readingcomprehensionapp.R;


public class MainActivity extends Activity implements View.OnClickListener {

    Button soundToText, soundToPicture, pictureToText, textToPictures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tim_activity_main);
        soundToText = (Button) findViewById(R.id.soundToText);
        soundToPicture = (Button) findViewById(R.id.soundToPicture);
        pictureToText = (Button) findViewById(R.id.pictureToText);
        textToPictures = (Button) findViewById(R.id.textToPictures);
    }

    @Override
    public void onClick(View v) {
        boolean goodProblem = true;
        int vid = v.getId();
        switch (vid) {
            case R.id.soundToText: {
//put name of sound-to-text activity in place of "ResultActivity"
                //Intent intent = new Intent(this, ResultActivity.class);
                //intent.putExtra("gameState", gameState);
                //startActivity(intent);
                //finish(); - This is home page. Keep it up.
                break;
            }
            case R.id.soundToPicture: {
//put name of sound-to-picture activity in place of "ResultActivity"
                Intent intent = new Intent(this, SoundToPictureActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.pictureToText: {
//put name of picture-to-text activity in place of "ResultActivity"
                //Intent intent = new Intent(this, ResultActivity.class);
                //intent.putExtra("gameState", gameState);
                //startActivity(intent);
                //finish(); - This is home page. Keep it up.
                break;
            }
            case R.id.textToPictures: {
//put name of text-to-pictures activity in place of "ResultActivity"
                //Intent intent = new Intent(this, ResultActivity.class);
                //intent.putExtra("gameState", gameState);
                //startActivity(intent);
                //finish(); - This is home page. Keep it up.
                break;
            }
        }

    }

}
