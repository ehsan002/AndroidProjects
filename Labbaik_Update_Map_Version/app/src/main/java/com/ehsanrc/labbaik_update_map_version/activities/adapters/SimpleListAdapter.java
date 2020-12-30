package com.ehsanrc.labbaik_update_map_version.activities.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ehsanrc.labbaik_update_map_version.R;

/**
 * Created by USER on 19/06/2016.
 */
public class SimpleListAdapter extends BaseAdapter {

    String[] list;
    Activity activity;

    public SimpleListAdapter(Activity activity, String[] list) {

        this.activity = activity;
        this.list = list;

    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public Object getItem(int position) {
        return list[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String list_item = list[position];

        if (convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.simple_listview_item,parent,false);

            ViewHolder viewHolder = new ViewHolder();

            viewHolder.list_item = (TextView) convertView.findViewById(R.id.textView_list_item);

//            if(deviceHeight<deviceWidth)
//            {
//                viewHolder.image.getLayoutParams().width = deviceWidth/2;
//                viewHolder.image.getLayoutParams().height = (4*(deviceWidth/2))/6;
//            }
//            else {
//                int w = (deviceWidth*90)/100;
//                viewHolder.image.getLayoutParams().width = w;
//                viewHolder.image.getLayoutParams().height = (4*w)/6;
//            }

            convertView.setTag(viewHolder);

        }

        final ViewHolder holder = (ViewHolder) convertView.getTag();

        //holder.activityName.setText(name);
        holder.list_item.setText(list_item);

        return convertView;
    }

    static class ViewHolder {

        TextView list_item;
    }
}
