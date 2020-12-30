package com.ehsanrc.labbaik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Hajj1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hajj1);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("হজ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button1 = (Button) findViewById(R.id.btn_hajj_rules);
        Button button2 = (Button) findViewById(R.id.btn_hajj_farj);
        Button button3 = (Button) findViewById(R.id.btn_hajj_wajib);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Hajj1.this,Hajj.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Hajj1.this, ScrollingActivity.class);
                intent.putExtra("button","farj");
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Hajj1.this, ScrollingActivity.class);
                intent.putExtra("button","wajib");
                startActivity(intent);
            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onBackPressed();
        return true;

    }

}
