package com.ehsanrc.labbaik;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	private Context context;
	String[] drawerItem;

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

		//LinearLayout layout = (LinearLayout) rootView
		//		.findViewById(R.id.list_layout);

		TextView tView = (TextView) rootView.findViewById(R.id.textView1);
		tView.setText(drawerItem[position]);

		if (drawerItem.length != 4) {
			//layout.setBackgroundColor(Color.parseColor("#0e1c04"));
			tView.setTextColor(Color.parseColor("#ffffff"));
		} else {
			//layout.setBackgroundColor(Color.parseColor("#2f1f0c"));
			tView.setTextColor(Color.parseColor("#ffffff"));
		}

		return rootView;
	}

}
