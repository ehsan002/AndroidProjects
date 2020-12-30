package com.ehsanrc.labbaik;

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
		String for_title = getResources().getString(R.string.title_hajj);
		String for_deatil = getResources().getString(R.string.hajj_detail1);
		String farj_title = getResources().getString(R.string.farj_title);
		String farj_deatil = getResources().getString(R.string.farj_det);
		String forbidden_title = getResources().getString(R.string.title_forbid_ihram);
		String forbidden_deatil = getResources().getString(R.string.det_forbid_ihram);
		
		
		TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
		TextView tvDetail = (TextView) view.findViewById(R.id.tvDet);
		switch (position) {

		case 1:
			tvTitle.setText(for_title);
			tvDetail.setText(for_deatil);
			break;

		case 2:
			tvTitle.setText(farj_title);
			tvDetail.setText(farj_deatil);
			break;
				
		case 3:
			tvTitle.setText(forbidden_title);
			tvDetail.setText(forbidden_deatil);
			break;
			
		case 4:
			tvTitle.setText(about_title);
			tvDetail.setText(about_deatil);
			break;

		default:
			break;
		}

		return view;
	}
}
