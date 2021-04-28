package com.example.downloadingwebcontents;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... urls) {


        Log.i("Result", "Running here");

        String result = "";

        URL url;

        HttpURLConnection httpURLConnection = null;

        try {
            url = new URL(urls[0]);


            httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            Log.i("Result", String.valueOf(url));

            int data = reader.read();

            while (data != -1){
                char current = (char) data;
                result+=current;
                data = reader.read();
            }


            Log.i("Result", result);

            return result;

        } catch (Exception e) {
            e.printStackTrace();
            Log.i("Result", "Exeption");
        }

        Log.i("Test", urls[0]);
        return "Failed";
    }
}
