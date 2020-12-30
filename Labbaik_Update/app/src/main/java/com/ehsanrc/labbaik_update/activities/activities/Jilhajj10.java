package com.ehsanrc.labbaik_update.activities.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ehsanrc.labbaik_update.R;
import com.ehsanrc.labbaik_update.activities.adapters.HajjAdapter;
import com.ehsanrc.labbaik_update.activities.lists.ActivityListHajj;

import java.util.ArrayList;

public class Jilhajj10 extends Fragment {

    private ActivityListHajj activity_jilhajj10;
    private HajjAdapter adapter;
    private ArrayList<ActivityListHajj> activities = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_jilhajj10, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listView_jilhajj10);

        final int[] imageResources = {R.drawable.cover,R.drawable.main,R.drawable.cover,R.drawable.main,R.drawable.cover,R.drawable.main};
        final String[] activities_jilhajj10 = getResources().getStringArray(R.array.hajj_activities_jilhajj10);
        final String[] activity_detail = getResources().getStringArray(R.array.activity_detail_jilhajj_10);

        for(int i = 0; i<activities_jilhajj10.length;i++)
        {
            activity_jilhajj10 = new ActivityListHajj(activities_jilhajj10[i],imageResources[i]);
            activities.add(activity_jilhajj10);
        }

        adapter = new HajjAdapter(getActivity(),activities);
        //adapter = new HajjAdapter(getActivity(),activities_jilhajj8);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),Detail.class);
                Bundle bundle = new Bundle();
                bundle.putStringArray("titles",activities_jilhajj10);
                bundle.putStringArray("strings",activity_detail);
                bundle.putIntArray("image",imageResources);
                bundle.putInt("pos",position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        return view;
    }
}
