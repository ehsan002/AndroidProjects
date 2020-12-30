package com.ehsanrc.labbaik;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends Activity {

	String title, detail;
	TextView tvTit, tvDet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		Intent intent = getIntent();
		int pos = intent.getIntExtra("Pos", 0);

		switch (pos) {

		case 0:
			title = getResources().getString(R.string.farj_title);
			detail = getResources().getString(R.string.farj_det);
			break;

		case 2:
			title = getResources().getString(R.string.title_umrah);
			detail = getResources().getString(R.string.det_umrah);
			break;
			
		case 3:
			title = getResources().getString(R.string.title_dua);
			detail = getResources().getString(R.string.det_dua);
			break;


		default:
			break;
		}

		tvTit = (TextView) findViewById(R.id.tv_tit);
		tvDet = (TextView) findViewById(R.id.tv_det);

		tvTit.setText(title);
		tvDet.setText(detail);

	}

		public boolean onOptionsItemSelected(MenuItem item) {
			super.onBackPressed();
			return true;
	
		}
}
