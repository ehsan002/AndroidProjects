package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timestableList;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSeekBar();

    }

    void setSeekBar(){

        seekBar = findViewById(R.id.seekbar);
        seekBar.setMax(20);
        seekBar.setProgress(1);

        showTimestable(1);

        Log.i("Progress", Integer.toString(seekBar.getProgress()));

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar2, int progress, boolean b) {

                if (progress<1){
                    progress++;
                    seekBar.setProgress(1);
                }

                showTimestable(progress);
                Log.i("See Progress: ", Integer.toString(progress));


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    void showTimestable(int number){

        timestableList = findViewById(R.id.listview_timestable);

        ArrayList<String> timestable = new ArrayList<>();

        for(int i = 1;i<=10;i++){
            timestable.add(Integer.toString(number*i));
            Log.i("Namota ", timestable.get(i-1));
        }

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, timestable);
        timestableList.setAdapter(myAdapter);

    }
}