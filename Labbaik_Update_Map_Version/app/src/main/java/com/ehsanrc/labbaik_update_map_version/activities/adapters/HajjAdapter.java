package com.ehsanrc.labbaik_update_map_version.activities.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ehsanrc.labbaik_update_map_version.R;
import com.ehsanrc.labbaik_update_map_version.activities.lists.ActivityListHajj;

import java.util.List;

/**
 * Created by USER on 12/06/2016.
 */
public class HajjAdapter extends BaseAdapter {

    Context activity;
    List<ActivityListHajj> activityList;
    String[] activityNames;

    public HajjAdapter(Activity activity, List<ActivityListHajj> activityList) {
        this.activity = activity;
        this.activityList = activityList;
    }

//    public HajjAdapter(Activity activity1, String[] activityNames) {
//        this.activity = activity1;
//        this.activityNames = activityNames;
//    }

    @Override
    public int getCount() {
        //return activityList.size();
        return activityList.size();
    }

    @Override
    public Object getItem(int position) {
        return activityList.get(position);
        //return activityNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        int deviceWidth = displayMetrics.widthPixels;
        int deviceHeight = displayMetrics.heightPixels;

        ActivityListHajj hajjActivity = (ActivityListHajj) getItem(position);
        //String name = activityNames[position];

        if (convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_hajj,parent,false);

            ViewHolder viewHolder = new ViewHolder();

            viewHolder.activityName = (TextView) convertView.findViewById(R.id.activityName);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.activityImage);

            if(deviceHeight<deviceWidth)
            {
                viewHolder.image.getLayoutParams().width = deviceWidth/2;
                viewHolder.image.getLayoutParams().height = (4*(deviceWidth/2))/6;
            }
            else {
                int w = (deviceWidth*90)/100;
                viewHolder.image.getLayoutParams().width = w;
                viewHolder.image.getLayoutParams().height = (4*w)/6;
            }

            convertView.setTag(viewHolder);

        }

        final ViewHolder holder = (ViewHolder) convertView.getTag();

        //holder.activityName.setText(name);
        holder.activityName.setText(hajjActivity.getActivityName());
        holder.image.setImageResource(hajjActivity.getImage());

        return convertView;
    }

    static class ViewHolder {

        TextView activityName;
        ImageView image;
    }
}
