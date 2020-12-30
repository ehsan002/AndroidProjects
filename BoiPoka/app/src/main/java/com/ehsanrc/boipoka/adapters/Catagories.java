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
 * Created by USER on 25/02/2016.
 */
public class Catagories extends BaseAdapter {

    Activity activity;
    List<String> lists;

    public Catagories(Activity activity, List<String> lists) {
        this.activity = activity;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String category = (String) getItem(position);

        if (convertView==null){

            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.categories_grid_item,parent,false);

            ViewHolder viewHolder = new ViewHolder();

            viewHolder.categoryImage = (ImageView) convertView.findViewById(R.id.iv_category_image);
            viewHolder.categoryName = (TextView) convertView.findViewById(R.id.tv_category_name);

            convertView.setTag(viewHolder);

        }

        final ViewHolder holder = (ViewHolder) convertView.getTag();

        holder.categoryName.setText(category);

        return convertView;
    }

    static class ViewHolder {
        ImageView categoryImage;
        TextView categoryName;
    }

}
