package com.ehsanrc.labbaik;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Hajj extends Activity {

	private Button farj, wajib, daily;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hajj);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		daily.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(Hajj.this, DailyTask.class);
				startActivity(intent);

			}
		});

	}

	public boolean onOptionsItemSelected(MenuItem item) {
		super.onBackPressed();
		return true;

	}

}
