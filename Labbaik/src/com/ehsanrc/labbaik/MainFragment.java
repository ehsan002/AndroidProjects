package com.ehsanrc.labbaik;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {

	public MainFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_main_fragment,
				container, false);
		Button btn_hajj = (Button) rootView.findViewById(R.id.btn_hajj);
		Button btn_umra = (Button) rootView.findViewById(R.id.btn_umra);
		Button btn_dua = (Button) rootView.findViewById(R.id.btn_dua);
		
		btn_hajj.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent intent = new Intent(getActivity(), DailyTask.class);
				startActivity(intent);
			}
		});

		btn_umra.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent intent = new Intent(getActivity(), DetailActivity.class);
				intent.putExtra("Pos", 2);
				startActivity(intent);
			}
		});

		btn_dua.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent intent = new Intent(getActivity(), DetailActivity.class);
				intent.putExtra("Pos", 3);
				startActivity(intent);
			}
		});

		return rootView;
	}

}
