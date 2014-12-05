package com.bluesky.readingcomprehensionapp;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bluesky.readingcomprehensionapp.R;

import java.io.IOException;


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
                Intent intent = new Intent(this, PictureToTextActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.textToPictures: {
                Intent intent = new Intent(this, TextToPicturesActivity.class);
                startActivity(intent);
                break;
            }
        }

    }

}
