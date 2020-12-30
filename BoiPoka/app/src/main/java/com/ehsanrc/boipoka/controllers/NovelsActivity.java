package com.ehsanrc.boipoka.controllers;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.ehsanrc.boipoka.R;
import com.ehsanrc.boipoka.adapters.BookListAdapter;
import com.ehsanrc.boipoka.adapters.Bookl;
import com.ehsanrc.boipoka.app.AppController;
import com.ehsanrc.boipoka.database.SQLiteHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NovelsActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener  {

    private String TAG = NovelsActivity.class.getSimpleName();
    private String URL_TOP_251 = "http://drishtibd.com/boipoka/json_list_books.php?";
    private ListView listView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private BookListAdapter adapter;
    private List<Bookl> booksList;
    int rank;
    String usid;
    String rand;
    String url;
    private int s = 0;
    private int e = 4;
    ImageButton back;
    private SQLiteHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novels);
        listView = (ListView) findViewById(R.id.categorizedBookList);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        back=(ImageButton)findViewById(R.id.icon);
        booksList = new ArrayList<>();
        adapter = new BookListAdapter(this, booksList);
        listView.setAdapter(adapter);
        db = new SQLiteHandler(getApplicationContext());
        HashMap<String, String> user = db.getUserDetails();
        rand = user.get("rand");
        usid = user.get("userid");
        swipeRefreshLayout.setOnRefreshListener(NovelsActivity.this);
        swipeRefreshLayout.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        listView.setEnabled(false);
                                        booksList.clear();
                                        swipeRefreshLayout.setRefreshing(true);
                                        fetchMovies();
                                    }
                                }
        );




    }


    /**
     * This method is called when swipe refresh is pulled down
     */
    @Override
    public void onRefresh() {
        listView.setEnabled(false);
        booksList.clear();
        fetchMovies();
    }

    /**
     * Fetching movies json by making http call
     */
    private void fetchMovies() {
        listView.setEnabled(false);
        // showing refresh animation before making http call
        swipeRefreshLayout.setRefreshing(true);



        // appending offset to url
        url = URL_TOP_251 + "&lim_start=" + s + "&lim_end=" + e;
        // Volley's json array request object
        JsonArrayRequest req = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(final JSONArray response) {
                Log.d(TAG, response.toString());
                if (response.length() > 0) {

                    int l = response.length();

                    // looping through json and adding to movies list
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject movieObj = response.getJSONObject(i);
                            rank = movieObj.getInt("book_id");
                            String title = movieObj.getString("book_name");
                            String title2 = movieObj.getString("author");
                            String im = movieObj.getString("image_extension");
                            String time = movieObj.getString("publish_date");
                            //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            //// long tm = Long.parseLong("publish_date");
                            // java.util.Date currenTimeZone=new java.util.Date((long)tm*1000);
                            //// String strLong = sdf.format(currenTimeZone);

                            Bookl m = new Bookl(rank, title, title2,im,time);
                            booksList.add(0, m);

                            if (l >= e) {
                                e = l + 4;
                            }
                        } catch (JSONException e) {
                            Log.e(TAG, "JSON Parsing error: " + e.getMessage());
                        }

                    }
                    adapter.notifyDataSetChanged();
                }
                // stopping swipe refresh
                swipeRefreshLayout.setRefreshing(false);
                listView.setEnabled(true);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {

                        int b = response.length();
                        int d = b - position-1;
                        try {
                            Log.e(TAG, "list" + d);
                            JSONObject movieObj2 = response.getJSONObject(d);
                            String rank = movieObj2.getString("book_id");

                            Intent i = new Intent(NovelsActivity.this, Chapters.class);
                            i.putExtra("reti", rank);
                            startActivity(i);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Server Error: " + error.getMessage());

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(NovelsActivity.this, R.style.AppCompatAlertDialogStyle);

                builder.setTitle("বার্তা");
                builder.setMessage("আবার চেষ্টা করুন । ");
                builder.setCancelable(false);
                builder.setNegativeButton("ঠিক আছে ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        onRefresh();
                    }
                });
                builder.setPositiveButton("প্রস্থান করুন", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.show();
                // stopping swipe refresh
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(req);
    }





}