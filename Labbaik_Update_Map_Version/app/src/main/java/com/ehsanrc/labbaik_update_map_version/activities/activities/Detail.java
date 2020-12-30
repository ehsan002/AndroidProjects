package com.ehsanrc.labbaik_update_map_version.activities.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ehsanrc.labbaik_update_map_version.R;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] umrah_activity_detail = getResources().getStringArray(R.array.umrah);
        String[] umrah_activity_title = getResources().getStringArray(R.array.umrah_activities);

        Intent intent = getIntent();
//        int position = intent.getIntExtra("pos",0);

        Bundle bundle = this.getIntent().getExtras();
        String[] string_array = bundle.getStringArray("strings");
        String[] title_array = bundle.getStringArray("titles");
        int[] images = bundle.getIntArray("image");
        int position = bundle.getInt("pos",0);

        getSupportActionBar().setTitle(title_array[position]);

        TextView textView = (TextView) findViewById(R.id.tv_umra_detail);
        textView.setText(string_array[position]);

        ImageView imageView = (ImageView) findViewById(R.id.image_in_detail);
        imageView.setImageResource(images[position]);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Detail.this,MainActivity.class);
                startActivity(intent1);
                //finish();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onBackPressed();
        return true;

    }
}
