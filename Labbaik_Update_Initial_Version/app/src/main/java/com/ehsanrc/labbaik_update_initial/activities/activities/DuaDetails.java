package com.ehsanrc.labbaik_update_initial.activities.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.ehsanrc.labbaik_update_initial.R;

public class DuaDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua_details);

        String[] dua_names = getResources().getStringArray(R.array.dua_names);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final String[] dua_arabic = getResources().getStringArray(R.array.dua_arabic);
        final String[] dua_pronounciation = getResources().getStringArray(R.array.dua_pronounciation);
        final String[] dua_meaning = getResources().getStringArray(R.array.bangla_meaning);

        Intent intent = getIntent();
        int position = intent.getIntExtra("pos",0);

        getSupportActionBar().setTitle(dua_names[position]);

        TextView tv_dua_arabic = (TextView) findViewById(R.id.tv_dua_arabic);
        TextView tv_dua_pron = (TextView) findViewById(R.id.tv_dua_pron);
        TextView tv_dua_meaning = (TextView) findViewById(R.id.tv_dua_bangla);

        tv_dua_arabic.setText(dua_arabic[position]);
        tv_dua_pron.setText(dua_pronounciation[position]);
        tv_dua_meaning.setText(dua_meaning[position]);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_dua_details);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(DuaDetails.this,MainActivity.class);
                startActivity(intent1);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onBackPressed();
        return true;

    }
}
