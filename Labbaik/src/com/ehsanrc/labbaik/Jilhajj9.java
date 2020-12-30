package com.ehsanrc.labbaik;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Jilhajj9 extends Activity {

	private Button btn_nxt, btn_prv, button2;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jilhajj9);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		btn_nxt = (Button) findViewById(R.id.btn_9_nxt);
		btn_prv = (Button) findViewById(R.id.btn_9_prv);
		button2 = (Button) findViewById(R.id.btn_hme9);

		btn_nxt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Jilhajj9.this, Jilhajj10.class);
				startActivity(intent);
			}
		});

		btn_prv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Jilhajj9.this, DailyDetail.class);
				startActivity(intent);
			}
		});

		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(Jilhajj9.this, MainActivity.class);
				startActivity(intent);

			}
		});

	}

	public boolean onOptionsItemSelected(MenuItem item) {
		super.onBackPressed();
		return true;

	}

}
