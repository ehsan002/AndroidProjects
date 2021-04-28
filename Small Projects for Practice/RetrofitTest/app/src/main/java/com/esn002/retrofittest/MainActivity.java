package com.esn002.retrofittest;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String[] contents = new String[1000];
    String titleTest = "test";
    List<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleTest = "OK?";

        getData();

        Log.i("Testing", titleTest);


    }

    private void getData(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()){
                    contents[0] = "Code: "+ response.code();
                    return;
                }

                posts = response.body();
                int i = 0;
                for (Post post:posts){
                    String content = "";
                    content += "\nID: " + post.getId();
                    content += "\nUserID: " + post.getUserId();
                    content += "\nTitle: " + post.getTitle();
                    contents[i] = content;
                    i++;
                    //textView.append(post.getTitle());
                }

                Log.i("Testing", "Inside Functioning");
                Log.i("Testing", contents[0]);
                titleTest = "jhgjhg";
                setListview();

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                contents[0] = "Code: "+ t.getMessage();
            }
        });

    }

    private void setListview(){

        ListView listView = findViewById(R.id.listview_retro);
        MyAdapter adapter = new MyAdapter(this, posts);
        listView.setAdapter(adapter);
        Log.i("Testing", posts.get(0).getTitle());

    }
}