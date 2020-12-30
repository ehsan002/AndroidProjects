package com.ehsanrc.zikr;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MainFragment extends ListFragment {

	private String[] strings;

	public MainFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.home, container, false);

		strings = getResources().getStringArray(R.array.dua_list);

		MyAdapter adapter2 = new MyAdapter(getActivity(), strings);

		setListAdapter(adapter2);

		return rootView;
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {

		Intent intent = new Intent(getActivity(), DetailActivity.class);
		intent.putExtra("Pos", position);
		startActivity(intent);
		super.onListItemClick(l, v, position, id);
	}
}
