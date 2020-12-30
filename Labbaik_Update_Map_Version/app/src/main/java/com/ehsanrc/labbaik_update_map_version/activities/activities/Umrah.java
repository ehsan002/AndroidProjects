package com.ehsanrc.labbaik_update_map_version.activities.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ehsanrc.labbaik_update_map_version.R;
import com.ehsanrc.labbaik_update_map_version.activities.adapters.HajjAdapter;
import com.ehsanrc.labbaik_update_map_version.activities.lists.ActivityListHajj;

import java.util.ArrayList;

public class Umrah extends AppCompatActivity {

    private ActivityListHajj activity_umrah;
    private HajjAdapter adapter;
    private ArrayList<ActivityListHajj> activities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umrah);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("উমরা");

        ListView listView = (ListView) findViewById(R.id.listview_umrah);

        final int[] imageResources = {R.drawable.cover,R.drawable.main,R.drawable.cover};
        final String[] titles_umrah = getResources().getStringArray(R.array.umrah_activities);
        final String[] activities_umrah = getResources().getStringArray(R.array.umrah);

        for(int i = 0; i<activities_umrah.length;i++)
        {
            activity_umrah = new ActivityListHajj(titles_umrah[i],imageResources[i]);
            activities.add(activity_umrah);
        }

        adapter = new HajjAdapter(this,activities);
        //adapter = new HajjAdapter(getActivity(),activities_jilhajj8);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Umrah.this,Detail.class);

                Bundle bundle = new Bundle();
                bundle.putStringArray("titles",titles_umrah);
                bundle.putStringArray("strings",activities_umrah);
                bundle.putIntArray("image",imageResources);
                bundle.putInt("pos",position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onBackPressed();
        return true;

    }
}
