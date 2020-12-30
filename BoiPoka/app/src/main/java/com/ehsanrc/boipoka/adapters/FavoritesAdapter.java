package com.ehsanrc.boipoka.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ehsanrc.boipoka.R;

import java.util.List;

/**
 * Created by USER on 28/02/2016.
 */
public class FavoritesAdapter extends BaseAdapter {

    Activity activity;
    List<String> favoriteBooks;

    public FavoritesAdapter(Activity activity, List<String> favoriteBooks) {
        this.activity = activity;
        this.favoriteBooks = favoriteBooks;
    }

    @Override
    public int getCount() {
        return favoriteBooks.size();
    }

    @Override
    public Object getItem(int position) {
        return favoriteBooks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String book = (String) getItem(position);

        if (convertView==null){

            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_favorites,parent,false);

            ViewHolder viewHolder = new ViewHolder();

            viewHolder.bookName = (TextView) convertView.findViewById(R.id.bookName);
            viewHolder.authorName = (TextView) convertView.findViewById(R.id.authorName);
            viewHolder.menu = (ImageView) convertView.findViewById(R.id.menu);

            convertView.setTag(viewHolder);

        }

        final ViewHolder holder = (ViewHolder) convertView.getTag();

        holder.menu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                activity.registerForContextMenu(holder.menu);
                activity.openContextMenu(holder.menu);
            }
        });

        holder.bookName.setText(book);

        return convertView;
    }

    static class ViewHolder {
        ImageView bookCover;
        ImageView menu;
        TextView bookName;
        TextView authorName;
    }
}
