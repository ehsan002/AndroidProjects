package com.example.downloadingwebcontents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Result", "Running");

        String result = "";
        DownloadTask task = new DownloadTask();
        Log.i("Result", "Still Running");
        try {

            Log.i("Result", "Still Running here");
            result = task.execute("http://dustyfeet.com/").get();
            Log.i("Result", "Still Running here too");
        } catch (ExecutionException e) {
            Log.i("Result", "Exeption");
            e.printStackTrace();
        } catch (InterruptedException e) {

            Log.i("Result", "Exeption 2");
            e.printStackTrace();
        }

        Log.i("Result", result);

    }
}