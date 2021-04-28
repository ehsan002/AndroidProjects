package com.esn002.retrofittest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    Context context;
    List<Post> posts;

    public MyAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int i) {
        return posts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        final Post post = posts.get(position);

        Log.i("Test", "get view working");

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.listitem, null);
        }

        final TextView tvID = convertView.findViewById(R.id.textViewID);
        final TextView tvUserId = convertView.findViewById(R.id.textViewUserID);
        final TextView tvTitle = convertView.findViewById(R.id.textViewTitle);

        tvID.setText(String.valueOf(post.getId()));
        tvUserId.setText(String.valueOf(post.getUserId()));
        tvTitle.setText(post.getTitle());

        Log.i("Test", post.getTitle());

        return convertView;
    }
}
