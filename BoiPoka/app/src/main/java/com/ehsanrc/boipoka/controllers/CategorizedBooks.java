package com.ehsanrc.boipoka.controllers;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ehsanrc.boipoka.R;
import com.ehsanrc.boipoka.adapters.BookListAdapter;

import java.util.ArrayList;
import java.util.List;

public class CategorizedBooks extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;
    private List<String> books;
    private BookListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorized_books);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        ListView bookList = (ListView) findViewById(R.id.categorizedBookList);
        swipeRefreshLayout.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) this);

        String[] bookNames = {"Computer Programming", "Algorithms", "Data Structures"};
        String[] authorNames = {"Tanim Shahriar Subeen", "Cormen", "Seymour Lipschutz"};

        books = new ArrayList<String>();

        for (int p = 0;p<bookNames.length;p++)
        {
            books.add(bookNames[p]);
        }

        adapter = new BookListAdapter(this,books);
        bookList.setAdapter(adapter);

        bookList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CategorizedBooks.this,Chapters.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onRefresh() {
        Toast.makeText(this,"Refreshing",Toast.LENGTH_SHORT).show();
        swipeRefreshLayout.setRefreshing(false);
    }

    final int CONTEXT_MENU_ABOUT =1;
    final int CONTEXT_MENU_REVIEW =2;
    final int CONTEXT_MENU_FAVORITES =3;
    final int CONTEXT_MENU_TO_READ =4;
    final int CONTEXT_MENU_READING =5;
    final int CONTEXT_MENU_DELETE =6;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

//        AdapterView.AdapterContextMenuInfo info;
//        info = (AdapterView.AdapterContextMenuInfo) menuInfo;
//        int index = sectionAdapter.getIndexForPosition(info.position);
        menu.setHeaderTitle("Actions");
        menu.add(Menu.NONE, CONTEXT_MENU_ABOUT, Menu.NONE, "About");
        menu.add(Menu.NONE, CONTEXT_MENU_REVIEW, Menu.NONE, "Review");
        menu.add(Menu.NONE, CONTEXT_MENU_FAVORITES, Menu.NONE, "Add to Favorites");
        menu.add(Menu.NONE, CONTEXT_MENU_TO_READ, Menu.NONE, "Add to To Read");
        menu.add(Menu.NONE, CONTEXT_MENU_READING, Menu.NONE, "Add to Reading");
        menu.add(Menu.NONE, CONTEXT_MENU_DELETE, Menu.NONE, "Delete");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item
                .getMenuInfo();
//        Log.w("index","Value");
//        int index = info.position;
//        Log.w("index","Value"+index);
//        int pos=books.get(index).getId();

        switch(item.getItemId()) {
            case CONTEXT_MENU_ABOUT: {

                Intent intent = new Intent(CategorizedBooks.this,BookInfo.class);
//                intent.putExtra("Position",info.id);
                intent.putExtra("Tag",0);

                startActivity(intent);
            }
            break;
            case CONTEXT_MENU_REVIEW: {
                Intent intent = new Intent(CategorizedBooks.this,BookInfo.class);
                //intent.putExtra("Position",info.id);
                intent.putExtra("Tag",1);

                startActivity(intent);

            }
            break;
            case CONTEXT_MENU_FAVORITES: {
                Toast.makeText(this,"Add To Favorites!",Toast.LENGTH_SHORT).show();
            }
            break;

            case CONTEXT_MENU_TO_READ: {
                Toast.makeText(this,"Add To To Read!",Toast.LENGTH_SHORT).show();
            }
            break;

            case CONTEXT_MENU_READING: {
                Toast.makeText(this,"Add To Reading Now!",Toast.LENGTH_SHORT).show();
            }
            break;

            case CONTEXT_MENU_DELETE: {
                Toast.makeText(this,"Delete Book",Toast.LENGTH_SHORT).show();
            }
            break;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        onBackPressed();
        return true;
    }

}
