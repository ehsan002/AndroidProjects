package com.ehsanrc.labbaik_update.activities.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ehsanrc.labbaik_update.R;
import com.ehsanrc.labbaik_update.activities.adapters.Pager;

public class Hajj extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hajj);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Hajj Activities");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Jilhajj 8"));
        tabLayout.addTab(tabLayout.newTab().setText("Jilhajj 9"));
        tabLayout.addTab(tabLayout.newTab().setText("Jilhajj 10"));
        tabLayout.addTab(tabLayout.newTab().setText("Jilhajj 11-13"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager  = (ViewPager) findViewById(R.id.pager);

        Pager pager = new Pager(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pager);

        //tabLayout.setOnTabSelectedListener(this);
        tabLayout.setupWithViewPager(viewPager);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onBackPressed();
        return true;

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
