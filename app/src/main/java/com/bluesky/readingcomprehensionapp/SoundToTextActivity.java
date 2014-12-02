package com.bluesky.readingcomprehensionapp;

import android.media.AudioManager;
import android.app.Activity;
import android.media.SoundPool;
import android.os.Bundle;
import android.media.SoundPool.OnLoadCompleteListener;
import android.view.View.OnClickListener;

import com.bluesky.readingcomprehensionapp.R;


/**
 * Created by Tim on 12/2/2014.
 * edited by Jon - 12/2/2014.
 */

public class SoundToTextActivity extends Activity {
    private SoundPool soundPool;
    private int ball;
    private int bear;
    private int bee;
    private int book;
    private int bus;
    private int car;
    private int cat;
    private int circle;
    private int cow;
    private int dog;
    private int door;
    private int duck;
    private int egg;
    private int fish;
    private int flower;
    private int frog;
    private int goat;
    private int hat;
    private int house;
    private int leaf;
    private int lion;
    private int moon;
    private int pie;
    private int ship;
    private int sky;
    private int star;
    private int sun;
    private int square;
    private int tree;
    private int triangle;

    boolean plays = false, loaded = false;
    float actVolume, maxVolume, volume;
    AudioManager audioManager;

    private void ball(){ if (loaded && !plays){ soundPool.play(ball,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void bear(){ if (loaded && !plays){ soundPool.play(bear,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void bee(){ if (loaded && !plays){ soundPool.play(bee,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void book(){ if (loaded && !plays){ soundPool.play(book,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void bus(){ if (loaded && !plays){ soundPool.play(bus,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void car(){ if (loaded && !plays){ soundPool.play(car,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void cat(){ if (loaded && !plays){ soundPool.play(cat,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void circle(){ if (loaded && !plays){ soundPool.play(circle,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void cow(){ if (loaded && !plays){ soundPool.play(cow,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void dog(){ if (loaded && !plays){ soundPool.play(dog,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void door(){ if (loaded && !plays){ soundPool.play(door,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void duck(){ if (loaded && !plays){ soundPool.play(duck,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void egg(){ if (loaded && !plays){ soundPool.play(egg,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void fish(){ if (loaded && !plays){ soundPool.play(fish,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void flower(){ if (loaded && !plays){ soundPool.play(flower,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void frog(){ if (loaded && !plays){ soundPool.play(frog,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void goat(){ if (loaded && !plays){ soundPool.play(goat,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void hat(){ if (loaded && !plays){ soundPool.play(hat,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void house(){ if (loaded && !plays){ soundPool.play(house,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void leaf(){ if (loaded && !plays){ soundPool.play(leaf,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void lion(){ if (loaded && !plays){ soundPool.play(lion,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void moon(){ if (loaded && !plays){ soundPool.play(moon,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void pie(){ if (loaded && !plays){ soundPool.play(pie,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void ship(){ if (loaded && !plays){ soundPool.play(ship,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void sky(){ if (loaded && !plays){ soundPool.play(sky,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void star(){ if (loaded && !plays){ soundPool.play(star,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void sun(){ if (loaded && !plays){ soundPool.play(sun,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void square(){ if (loaded && !plays){ soundPool.play(square,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void tree(){ if (loaded && !plays){ soundPool.play(tree,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }
    private void triangle(){ if (loaded && !plays){ soundPool.play(triangle,volume, volume, 1, 0, 1f);
        plays = false;
    }
    }


    public void loadAudio() {

        // AudioManager audio settings for adjusting the volume
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        actVolume = (float) audioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC);
        maxVolume = (float) audioManager
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        volume = actVolume / maxVolume;

        // Hardware buttons setting to adjust the media sound
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);


        // Load the sounds
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                                       int status) {
                loaded = true;
            }
        });



    ball=soundPool.load(this,R.raw.ball,1);
    bear=soundPool.load(this,R.raw.bear,1);
    bee=soundPool.load(this,R.raw.bee,1);
    book=soundPool.load(this,R.raw.book,1);
    bus=soundPool.load(this,R.raw.bus,1);
    car=soundPool.load(this,R.raw.car,1);
    cat=soundPool.load(this,R.raw.cat,1);
    circle=soundPool.load(this,R.raw.circle,1);
    cow=soundPool.load(this,R.raw.cow,1);
    dog=soundPool.load(this,R.raw.dog,1);
    door=soundPool.load(this,R.raw.door,1);
    duck=soundPool.load(this,R.raw.duck,1);
    egg=soundPool.load(this,R.raw.egg,1);
    fish=soundPool.load(this,R.raw.fish,1);
    flower=soundPool.load(this,R.raw.flower,1);
    frog=soundPool.load(this,R.raw.frog,1);
    goat=soundPool.load(this,R.raw.goat,1);
    hat=soundPool.load(this,R.raw.hat,1);
    house=soundPool.load(this,R.raw.house,1);
    leaf=soundPool.load(this,R.raw.leaf,1);
    lion=soundPool.load(this,R.raw.lion,1);
    moon=soundPool.load(this,R.raw.moon,1);
    pie=soundPool.load(this,R.raw.pie,1);
    ship=soundPool.load(this,R.raw.ship,1);
    sky=soundPool.load(this,R.raw.sky,1);
    star=soundPool.load(this,R.raw.star,1);
    sun=soundPool.load(this,R.raw.sun,1);
    square=soundPool.load(this,R.raw.square,1);
    tree=soundPool.load(this,R.raw.tree,1);
    triangle=soundPool.load(this,R.raw.triangle,1);



}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.sound_to_word); NOT WORKING YET
        loadAudio();





    }
}