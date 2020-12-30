package com.ehsanrc.boipoka.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ehsanrc.boipoka.R;
import com.ehsanrc.boipoka.adapters.BookListAdapter;
import com.ehsanrc.boipoka.adapters.ChapterAdapter;

import java.util.ArrayList;
import java.util.List;

public class Chapters extends AppCompatActivity {

    private ChapterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listChapter = (ListView) findViewById(R.id.listChapters);

        String[] chaptersTitle = {"Chapter 1", "Chapter 2","Chapter 3","Chapter 4"};

        List<String> chapters = new ArrayList<String>();

        for (int p = 0;p<chaptersTitle.length;p++)
        {
            chapters.add(chaptersTitle[p]);
        }

        adapter = new ChapterAdapter(this,chapters);
        listChapter.setAdapter(adapter);

        listChapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Chapters.this,ChapterDetail.class);
                startActivity(intent);
            }
        });

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
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        onBackPressed();
        return true;
    }

}
