package com.ehsanrc.labbaik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import com.ehsanrc.labbaik.adapters.EventListAdapter;

public class Events extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("গুরুত্বপূর্ণ দিনসমূহ");

        String[] titles = getResources().getStringArray(R.array.event_titles);
        String[] date_a = getResources().getStringArray(R.array.event_date_arabic);
        String[] date_e = getResources().getStringArray(R.array.event_date_english);

        EventListAdapter adapter = new EventListAdapter(this,titles,date_a,date_e);

        ListView listView = (ListView) findViewById(R.id.listview_events);

        listView.setAdapter(adapter);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onBackPressed();
        return false;
    }
}
