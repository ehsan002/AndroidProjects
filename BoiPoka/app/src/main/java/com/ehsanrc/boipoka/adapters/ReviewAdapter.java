package com.ehsanrc.boipoka.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ehsanrc.boipoka.R;
import java.util.List;

/**
 * Created by Ehsan on 10/11/2015.
 */
public class ReviewAdapter extends BaseAdapter {

    Activity activity;
    List<String> list;

    public ReviewAdapter(Activity activity, List<String> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String  reviewer = (String) getItem(position);

        if(convertView==null){

            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_review,parent,false);

            ViewHolder viewHolder = new ViewHolder();

            viewHolder.reviewerName = (TextView) convertView.findViewById(R.id.tv_name_review);

            convertView.setTag(viewHolder);

        }

        final ViewHolder holder = (ViewHolder) convertView.getTag();

        holder.reviewerName.setText(reviewer);

        return convertView;
    }

    static class ViewHolder {
        TextView reviewerName;

    }
}
