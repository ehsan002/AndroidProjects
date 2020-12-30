package com.ehsanrc.labbaik_update.activities.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ehsanrc.labbaik_update.R;
import com.ehsanrc.labbaik_update.activities.adapters.HajjAdapter;
import com.ehsanrc.labbaik_update.activities.lists.ActivityListHajj;

import java.util.ArrayList;

public class Duas extends AppCompatActivity {

    private ActivityListHajj list_duas;
    private HajjAdapter adapter;
    private ArrayList<ActivityListHajj> duas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duas);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Duas");

        ListView listView = (ListView) findViewById(R.id.listView_duas);

        String[] dua_names = getResources().getStringArray(R.array.dua_names);

        int[] imageResources = {R.drawable.cover,R.drawable.main,R.drawable.cover};

        for(int i = 0; i<dua_names.length;i++)
        {
            list_duas = new ActivityListHajj(dua_names[i],imageResources[i]);
            duas.add(list_duas);
        }

        adapter = new HajjAdapter(this,duas);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Duas.this,DuaDetails.class);

                intent.putExtra("pos",position);

                startActivity(intent);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onBackPressed();
        return true;

    }
}
