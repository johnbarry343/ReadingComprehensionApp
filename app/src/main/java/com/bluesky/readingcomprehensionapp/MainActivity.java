package com.bluesky.readingcomprehensionapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bluesky.readingcomprehensionapp.R;


public class MainActivity extends Activity implements View.OnClickListener {

    Button soundToText, soundToPicture, pictureToText, textToPictures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tim_activity_main);
        soundToText = (Button) findViewById(R.id.soundToText);
        soundToText.setOnClickListener(this);
        soundToPicture = (Button) findViewById(R.id.soundToPicture);
        soundToPicture.setOnClickListener(this);
        pictureToText = (Button) findViewById(R.id.pictureToText);
        pictureToText.setOnClickListener(this);
        textToPictures = (Button) findViewById(R.id.textToPictures);
        textToPictures.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int vid = v.getId();
        switch (vid) {
            case R.id.soundToText: {
                Intent intent = new Intent(this, SoundToTextActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.soundToPicture: {
                Intent intent = new Intent(this, SoundToPictureActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.pictureToText: {
                Toast.makeText(this, "PictureToTextActivity",
                        Toast.LENGTH_SHORT).show();
//put name of picture-to-text activity in place of "ResultActivity"
                //Intent intent = new Intent(this, ResultActivity.class);
                //intent.putExtra("gameState", gameState);
                //startActivity(intent);
                //finish(); - This is home page. Keep it up.
                break;
            }
            case R.id.textToPictures: {
                Toast.makeText(this, "TextToPicturesActivity",
                        Toast.LENGTH_SHORT).show();
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
