package com.example.gridlayouttest;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    GridLayout gridLayout;

    boolean playing = false;

    MediaPlayer mediaPlayer;
//    int sounds[] = {R.raw.birds, R.raw.dog, R.raw.frogs, R.raw.marbles, R.raw.ocean,
//    R.raw.rain, R.raw.waterfall, R.raw.rooster, R.raw.storm};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
    }

    void initializeViews(){

        gridLayout = findViewById(R.id.gridLayout);

//        Button button1 = findViewById(R.id.buttonOne);
//        Button button2 = findViewById(R.id.buttonTwo);
//        Button button3 = findViewById(R.id.buttonThree);
//        Button button4 = findViewById(R.id.button4);
//        Button button6 = findViewById(R.id.buttonSix);
//        Button button7 = findViewById(R.id.buttonSeven);
//        Button button8 = findViewById(R.id.buttonEight);
//        Button button9 = findViewById(R.id.buttonNine);

        playSound();

    }

    void playSound(){

        for (int i = 0; i<gridLayout.getChildCount(); i++){
            final int finalI = i;

            gridLayout.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int randomId = view.getId();
                    String myId = view.getResources().getResourceEntryName(randomId);

                    int resourceId = getResources().getIdentifier(myId, "raw", "com.example.gridlayouttest");

                    if (playing){
                        mediaPlayer.pause();
                    }
                    else {
                        mediaPlayer = MediaPlayer.create(MainActivity.this, resourceId);
                        //mediaPlayer = MediaPlayer.create(MainActivity.this, sounds[finalI]);
                        //mediaPlayer = MediaPlayer.create(MainActivity.this, Uri.parse("http://soundbible.com/2208-Tasmanian-Devil.mp3"));
                        mediaPlayer.start();
                    }
                    playing = !playing;
                }
            });
        }

    }

}