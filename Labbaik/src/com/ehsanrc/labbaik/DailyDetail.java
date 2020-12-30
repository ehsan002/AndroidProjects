package com.ehsanrc.labbaik;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DailyDetail extends Activity {

	private Button button, button2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_daily_detail);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		button = (Button) findViewById(R.id.btn_8);
		button2 = (Button) findViewById(R.id.btn_hme8);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(DailyDetail.this, Jilhajj9.class);
				startActivity(intent);

			}
		});

		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(DailyDetail.this, MainActivity.class);
				startActivity(intent);

			}
		});

	}

	public boolean onOptionsItemSelected(MenuItem item) {
		super.onBackPressed();
		return true;

	}

}
