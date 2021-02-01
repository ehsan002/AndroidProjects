package com.ehsanrc.labbaik;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;

public class About extends AppCompatActivity {

    private static final String APP_PNAME = "com.ehsanrc.labbaik";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("About");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayout linearLayout_fb = (LinearLayout) findViewById(R.id.ll_facebook);
        linearLayout_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.facebook.com/rightcliks/"));
                startActivity(viewIntent);
            }
        });

        LinearLayout linearLayout_tt = (LinearLayout) findViewById(R.id.ll_twitter);
        linearLayout_tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://twitter.com/Rightcliks"));
                startActivity(viewIntent);
            }
        });

        LinearLayout linearLayout_gp = (LinearLayout) findViewById(R.id.ll_gplus);
        linearLayout_gp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://plus.google.com/u/0/105425245138597662872/"));
                startActivity(viewIntent);
            }
        });


        Button button = (Button) findViewById(R.id.btn_rate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PNAME)));
            }
        });

        Button like = (Button) findViewById(R.id.btn_like);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.facebook.com/AppforHajj/"));
                startActivity(viewIntent);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onBackPressed();

        return false;
    }
}
