package com.ehsanrc.zikr;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class About extends Fragment {

	int position;

	public About(int pos) {
		position = pos;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.activity_about, container, false);

		String about_title = getResources().getString(R.string.title_about);
		String about_deatil = getResources().getString(R.string.about_detail);
		String ref_title = getResources().getString(R.string.title_ref);
		String ref_deatil = getResources().getString(R.string.ref_detail1);
		String for_title = getResources().getString(R.string.title_for);
		String for_deatil = getResources().getString(R.string.for_detail1);

		TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
		TextView tvDetail = (TextView) view.findViewById(R.id.tvDet);
		switch (position) {

		case 1:
			tvTitle.setText(for_title);
			tvDetail.setText(for_deatil);
			break;

		case 2:
			tvTitle.setText(about_title);
			tvDetail.setText(about_deatil);
			break;

		case 3:
			tvTitle.setText(ref_title);
			tvDetail.setText(ref_deatil);
			break;

		default:
			break;
		}

		return view;
	}
}
