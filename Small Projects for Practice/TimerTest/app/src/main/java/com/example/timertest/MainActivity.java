package com.example.timertest;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBarTimer;
    Button buttonClick;
    TextView timerText;
    ImageView eggImage;
    CountDownTimer countDownTimer;
    MediaPlayer mediaPlayer;

    int countdownTime = 10;
    boolean clicked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initilaizeViews();

    }

    void initilaizeViews(){
        seekBarTimer = findViewById(R.id.seekBarTime);
        buttonClick = findViewById(R.id.btnClick);
        timerText = findViewById(R.id.countdownText);
        eggImage = findViewById(R.id.imageEgg);

        seekbarSetup();

        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSetup();
            }
        });
    }

    void seekbarSetup(){

        seekBarTimer.setMax(60);
        seekBarTimer.setProgress(10);
        seekBarTimer.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                if (progress >0)
                    countdownTime = progress;
                else {
                    countdownTime = ++progress;
                    seekBarTimer.setProgress(progress);
                }
                Log.i("Progress", Integer.toString(countdownTime));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    void timerSetUp(){

        countDownTimer = new CountDownTimer(countdownTime*1000+100, 1000){

            @Override
            public void onTick(long l) {
                timerText.setText("Time left: "+Long.toString(l/1000)+ " Seconds");
                Log.i("Time", Long.toString(l));
            }

            @Override
            public void onFinish() {
                timerText.setText("Bark!");
                playSound();
                buttonClick.setText("Start");
                clicked = !clicked;
                seekBarTimer.setVisibility(View.VISIBLE);
                Log.i("Time", "Over!");
            }
        };
        countDownTimer.start();

    }

    void buttonSetup(){
        Log.i("Progress", Integer.toString(countdownTime));

        if (clicked){
            countDownTimer.cancel();
            buttonClick.setText("Start");
            countdownTime = 10;
            timerText.setText("Timer Stopped!");
            seekBarTimer.setVisibility(View.VISIBLE);
        }else{
            timerSetUp();
            buttonClick.setText("Stop");
            seekBarTimer.setVisibility(View.INVISIBLE);
        }
        clicked = !clicked;
    }

    void playSound(){

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.dog);
        mediaPlayer.start();
    }

}