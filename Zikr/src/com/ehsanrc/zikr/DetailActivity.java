package com.ehsanrc.zikr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		Intent intent = getIntent();
		int pos = intent.getIntExtra("Pos", 0);

		String[] titles = getResources().getStringArray(R.array.dua_list);
		String[] arabic = getResources().getStringArray(R.array.arabic);
		String[] pron = getResources().getStringArray(R.array.uccharon);
		String[] bangla = getResources().getStringArray(R.array.onubad);
		// String[] ref = getResources().getStringArray(R.array.ref);

		TextView tv_title = (TextView) findViewById(R.id.title);
		tv_title.setText(titles[pos]);

		TextView tv_arabic = (TextView) findViewById(R.id.arabic);
		tv_arabic.setText(arabic[pos]);

		TextView tv_uccharon = (TextView) findViewById(R.id.uccharon);
		tv_uccharon.setText(pron[pos]);

		TextView tv_bangla = (TextView) findViewById(R.id.bangla);
		tv_bangla.setText(bangla[pos]);

		// TextView tv_ref = (TextView) findViewById(R.id.ref);
		// tv_ref.setText(ref[pos]);
		//

	}

	public boolean onOptionsItemSelected(MenuItem item) {
		super.onBackPressed();
		return true;

	}

}
