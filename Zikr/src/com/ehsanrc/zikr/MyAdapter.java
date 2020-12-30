package com.ehsanrc.zikr;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	private Context context;
	String[] drawerItem;
	int[] image = { R.drawable.ic_hom, R.drawable.ic_foreword,
			R.drawable.ic_about, R.drawable.ic_ref, R.drawable.ic_hom,
			R.drawable.ic_foreword, R.drawable.ic_about, R.drawable.ic_ref,
			R.drawable.ic_hom, R.drawable.ic_foreword, R.drawable.ic_about,
			R.drawable.ic_ref };

	public MyAdapter() {

		drawerItem = null;
	}

	public MyAdapter(Context context, String[] str) {
		this.context = context;
		drawerItem = str;
	}

	@Override
	public int getCount() {
		return drawerItem.length;
	}

	@Override
	public Object getItem(int position) {
		return drawerItem[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View rootView = null;

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rootView = inflater.inflate(R.layout.list_item, parent, false);
		} else {
			rootView = convertView;
		}

		LinearLayout layout = (LinearLayout) rootView
				.findViewById(R.id.list_layout);

		TextView tView = (TextView) rootView.findViewById(R.id.textView1);
		tView.setText(drawerItem[position]);
		if (drawerItem.length == 4) {
			ImageView iView = (ImageView) rootView
					.findViewById(R.id.imageView1);
			iView.setImageResource(image[position]);
		}

		if (drawerItem.length == 4) {
			layout.setBackgroundColor(Color.parseColor("#0e1c04"));
			tView.setTextColor(Color.parseColor("#ffffff"));
		} else {
			layout.setBackgroundColor(Color.parseColor("#336600"));
			tView.setTextColor(Color.parseColor("#ffffff"));
		}

		return rootView;
	}

}
