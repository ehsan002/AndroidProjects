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
 * Created by USER on 26/02/2016.
 */
public class ChapterAdapter extends BaseAdapter {

    Activity activity;
    List<String> chapters;

    public ChapterAdapter(Activity activity,List<String> chapters){
        this.activity = activity;
        this.chapters = chapters;
    }

    @Override
    public int getCount() {
        return chapters.size();
    }

    @Override
    public Object getItem(int position) {
        return chapters.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String chapter = (String) getItem(position);

        if (convertView==null){

            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_chapters,parent,false);

            ViewHolder viewHolder = new ViewHolder();

            viewHolder.chapterNo = (TextView) convertView.findViewById(R.id.chapterNo);
            viewHolder.chapterTitle = (TextView) convertView.findViewById(R.id.chapterTitle);
            viewHolder.chapterSubTitle = (TextView) convertView.findViewById(R.id.chapterSubTitle);

            convertView.setTag(viewHolder);

        }

        final ViewHolder holder = (ViewHolder) convertView.getTag();

        holder.chapterTitle.setText(chapter);

        return convertView;
    }

    static class ViewHolder {
        TextView chapterNo;
        TextView chapterTitle;
        TextView chapterSubTitle;
    }
}
