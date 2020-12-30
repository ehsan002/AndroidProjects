package com.ehsanrc.labbaik_update_initial.activities.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.ehsanrc.labbaik_update_initial.R;
import com.ehsanrc.labbaik_update_initial.activities.adapters.SimpleListAdapter;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listView = (ListView) findViewById(R.id.listView_details);

        String[] list_items = new String[0];

        String button_name = getIntent().getStringExtra("button");

        if (button_name.equals("ihram"))
        {
            list_items = getResources().getStringArray(R.array.forbidden_tasks);
        }

        if (button_name.equals("importance"))
        {
            list_items = getResources().getStringArray(R.array.importance);
        }

        if (button_name.equals("farj"))
        {
            list_items = getResources().getStringArray(R.array.farj);
        }

        if (button_name.equals("wajib"))
        {
            list_items = getResources().getStringArray(R.array.wajib);
        }

        SimpleListAdapter adapter = new SimpleListAdapter(this,list_items);

        listView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
