package com.ehsanrc.labbaik.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ehsanrc.labbaik.R;

/**
 * Created by USER on 05/07/2016.
 */
public class EventListAdapter extends BaseAdapter {

    Activity activity;
    String[] title, arabic_date, english_date;

    public EventListAdapter(Activity activity, String[] title, String[] arabic_date, String[] english_date) {
        this.activity = activity;
        this.title = title;
        this.arabic_date = arabic_date;
        this.english_date = english_date;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int position) {
        return title[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String li_title = title[position];
        String li_a_date = arabic_date[position];
        String li_eng_date = english_date[position];

        if (convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_events,parent,false);

            ViewHolder viewHolder = new ViewHolder();

            viewHolder.textView_title = (TextView) convertView.findViewById(R.id.tv_event_title);
            viewHolder.textView_a_date = (TextView) convertView.findViewById(R.id.tv_event_arabic_date);
            viewHolder.textView_eng_date = (TextView) convertView.findViewById(R.id.tv_event_english_date);

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

            Animation animation = AnimationUtils.loadAnimation(activity, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
            convertView.startAnimation(animation);
            lastPosition = position;

            convertView.setTag(viewHolder);

        }

        final ViewHolder holder = (ViewHolder) convertView.getTag();

        //holder.activityName.setText(name);
        holder.textView_title.setText(li_title);
        holder.textView_a_date.setText(li_a_date);
        holder.textView_eng_date.setText(li_eng_date);

        return convertView;

    }

    static class ViewHolder {

        TextView textView_title;
        TextView textView_a_date;
        TextView textView_eng_date;
    }
}
